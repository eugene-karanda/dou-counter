package org.overmind.doucounter.feed;

import lombok.Value;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:36
 */
@Value
public class FeedMessage {

    String title;

    String description;

    String link;

    String author;

    String guid;
}
