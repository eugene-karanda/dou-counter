package org.overmind.doucounter.feed;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:38
 */
@XmlRootElement(name = "rss")
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public final class Feed {

    @XmlElement(name = "channel")
    private Channel channel;

}
