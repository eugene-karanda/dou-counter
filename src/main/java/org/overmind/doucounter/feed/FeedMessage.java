package org.overmind.doucounter.feed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:36
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public final class FeedMessage {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "author")
    private String author;

    @XmlElement(name = "guid")
    private String guid;

}
