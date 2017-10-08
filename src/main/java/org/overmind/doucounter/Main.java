package org.overmind.doucounter;

import org.overmind.doucounter.feed.*;

import java.io.IOException;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 0:13
 */
public class Main {
    public static void main(String[] args) throws IOException, RSSFeedParserException {
        final RSSFeedParser parser = RSSFeedParserJAXB.create("https://jobs.dou.ua/vacancies/feeds/?search=Java");

        final Feed feed = parser.readFeed();

        feed.getChannel()
                .getMessages()
                .stream()
                .map(FeedMessage::getDescription)
                .limit(10)
                .peek(message -> System.out.println("------------------"))
                .forEach(System.out::println);

    }
}
