package org.overmind.doucounter.feed;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:36
 */
public final class FeedMessage {

    @XmlElement
    private String title;

    @XmlElement
    private String description;

    @XmlElement
    private String link;

    @XmlElement
    private String author;

    @XmlElement
    private String guid;

    private FeedMessage() {
    }

    public FeedMessage(String title, String description, String link, String author, String guid) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.author = author;
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getAuthor() {
        return author;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "FeedMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedMessage that = (FeedMessage) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(link, that.link) &&
                Objects.equals(author, that.author) &&
                Objects.equals(guid, that.guid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, link, author, guid);
    }
}
