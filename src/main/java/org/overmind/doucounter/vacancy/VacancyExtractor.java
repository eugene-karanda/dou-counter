package org.overmind.doucounter.vacancy;

import org.overmind.doucounter.feed.Feed;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:02
 */
public interface VacancyExtractor {

    List<Vacancy> extract(Feed feed) throws VacancyExtractingException;

}
