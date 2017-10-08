package org.overmind.doucounter.feed;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:38
 */
@XmlRootElement(name = "rss")
public final class Feed {

    @XmlElement
    private Channel channel;

    private Feed() {
    }

    public Feed(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "channel=" + channel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Objects.equals(channel, feed.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channel);
    }
}
