package org.overmind.doucounter.feed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:24
 */
@Getter
@ToString(exclude = "messages")
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public final class Channel {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "language")
    private String language;

    @XmlElement(name = "copyright")
    private String copyright;

    @XmlElement(name = "pubDate")
    private String publicationDate;

    @XmlElement(name = "item")
    private List<FeedMessage> messages;

}
