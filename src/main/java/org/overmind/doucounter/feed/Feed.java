package org.overmind.doucounter.feed;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:38
 */
@Value
@Builder
@ToString(exclude = "entries")
public class Feed {

    String title;

    String link;

    String description;

    String language;

    String copyright;

    String pubDate;

    @Singular
    List<FeedMessage> entries;

}
