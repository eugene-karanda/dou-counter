package org.overmind.doucounter.vacancy;

import lombok.Builder;
import lombok.Value;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 1:31
 */
@Value
@Builder
public class Vacancy {

    String link;

    String requiredSkills;

    String additionalSkills;

    String bePlus;

    String weOffers;

    String bonuses;

    String duty;

    String aboutProject;

}
