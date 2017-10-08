package org.overmind.doucounter.feed;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:24
 */
public final class Channel {

    @XmlElement
    private String title;

    @XmlElement
    private String link;

    @XmlElement
    private String description;

    @XmlElement
    private String language;

    @XmlElement
    private String copyright;

    @XmlElement
    private String pubDate;

    @XmlElement(name = "item")
    private List<FeedMessage> messages;

    private Channel() {
    }

    public Channel(String title, String link, String description, String language, String copyright, String pubDate, List<FeedMessage> messages) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
        this.messages = messages;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public List<FeedMessage> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", copyright='" + copyright + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return Objects.equals(title, channel.title) &&
                Objects.equals(link, channel.link) &&
                Objects.equals(description, channel.description) &&
                Objects.equals(language, channel.language) &&
                Objects.equals(copyright, channel.copyright) &&
                Objects.equals(pubDate, channel.pubDate) &&
                Objects.equals(messages, channel.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, link, description, language, copyright, pubDate, messages);
    }
}
