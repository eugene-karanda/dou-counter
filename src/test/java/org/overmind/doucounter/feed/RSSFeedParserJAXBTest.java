package org.overmind.doucounter.feed;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:11
 */
public class RSSFeedParserJAXBTest {

    private RSSFeedParserJAXB rssFeedParserJAXB;

    @Before
    public void setUp() throws Exception {
        this.rssFeedParserJAXB = RSSFeedParserJAXB.create("http://www.vogella.com/article.rss");
    }

    @Test
    public void readFeed() throws Exception {
        final Feed feed = rssFeedParserJAXB.readFeed();
        assertNotNull(feed);

        final List<FeedMessage> messages = feed.getChannel()
                .getMessages();

        assertNotNull(messages);
        assertFalse(messages.isEmpty());

    }
}