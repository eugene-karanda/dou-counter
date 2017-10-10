package org.overmind.doucounter.vacancy;

import org.overmind.doucounter.feed.Feed;
import org.overmind.doucounter.feed.FeedMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 10.10.2017 1:31
 */
public abstract class AbstractVacancyExtractor implements VacancyExtractor {

    @Override
    public final List<Vacancy> extract(Feed feed) throws VacancyExtractingException {
        final List<Vacancy> vacancies = new ArrayList<>();
        final List<FeedMessage> messages = feed.getChannel()
                .getMessages();

        for (FeedMessage message : messages) {
            try {
                vacancies.add(
                        extractVacancy(message)
                );
            } catch (Exception e) {
                throw new VacancyExtractingException("Exception during extracting: " + message, e);
            }
        }

        return vacancies;
    }

    protected abstract Vacancy extractVacancy(FeedMessage message) throws Exception;
}
