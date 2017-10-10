package org.overmind.doucounter.vacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.overmind.doucounter.feed.FeedMessage;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 10.10.2017 1:26
 */
public final class JsoupVacancyExtractor extends AbstractVacancyExtractor {

    @Override
    protected Vacancy extractVacancy(FeedMessage message) throws Exception {
        final Document document = Jsoup.parse(
                message.getDescription()
        );

        Vacancy.VacancyBuilder builder = Vacancy.builder();
        builder.link(message.getLink());

        final Elements requirementsElements = document.select(".requirements > .text");
        if (requirementsElements.size() > 0) {
            builder.requiredSkills(
                    extractText(requirementsElements.get(0))
            );
        }

        final Elements additionalSkillsElements = document.select(".additionalskils > .text");
        if (additionalSkillsElements.size() > 0) {
            builder.additionalSkills(
                    extractText(additionalSkillsElements.get(0))
            );
        }

        final Elements aboutProjectElements = document.select(".project > .text");
        if (aboutProjectElements.size() > 0) {
            builder.aboutProject(
                    extractText(aboutProjectElements.get(0))
            );
        }

        final Elements bonusesElements = document.select(".bonuses > .text");
        if (bonusesElements.size() > 0) {
            builder.bonuses(
                    extractText(bonusesElements.get(0))
            );
        }

        final Elements dutyElements = document.select(".duty > .text");
        if (dutyElements.size() > 0) {
            builder.bonuses(
                    extractText(dutyElements.get(0))
            );
        }

        return builder.build();
    }

    private String extractText(Element element) {
        return element.text();
    }
}
