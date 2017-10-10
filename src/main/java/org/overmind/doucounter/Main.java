package org.overmind.doucounter;

import org.overmind.doucounter.feed.Feed;
import org.overmind.doucounter.feed.RSSFeedParser;
import org.overmind.doucounter.feed.RSSFeedParserJAXB;
import org.overmind.doucounter.feed.RSSFeedParsingException;
import org.overmind.doucounter.vacancy.JsoupVacancyExtractor;
import org.overmind.doucounter.vacancy.Vacancy;
import org.overmind.doucounter.vacancy.VacancyExtractingException;
import org.overmind.doucounter.vacancy.VacancyExtractor;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 0:13
 */
public class Main {
    public static void main(String[] args) throws IOException, RSSFeedParsingException, VacancyExtractingException {
        final RSSFeedParser parser = RSSFeedParserJAXB.fromURL("https://jobs.dou.ua/vacancies/feeds/?search=Java");
        final Feed feed = parser.parse();

        final VacancyExtractor vacancyExtractor = new JsoupVacancyExtractor();
        final List<Vacancy> vacancies = vacancyExtractor.extract(feed);

        final List<String> excluded = Arrays.asList(
                "",
                "•"
        );

        final Map<String, Integer> countMap = vacancies.stream()
                .map((vacancy) -> vacancy.getRequiredSkills() + " " + vacancy.getAdditionalSkills())
                .map(String::toLowerCase)
                .map(str -> str.replace('\u00a0', ' '))
                .map(requiredSkills -> requiredSkills.split("\\s|\\(|\\)|,|;|\\.|-|—|:|/|\\?"))
                .map(Stream::of)
                .map(Stream::distinct)
                .flatMap(Function.identity())
                .filter(str -> !excluded.contains(str))
                .collect(Collectors.toMap(Function.identity(), (str) -> 1, (count, one) -> count + one));

        final List<Map.Entry<String, Integer>> sortedWords = countMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList());

        sortedWords.forEach(System.out::println);
    }
}
