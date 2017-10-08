package org.overmind.doucounter;

import org.junit.Before;
import org.junit.Test;
import org.overmind.doucounter.feed.Feed;
import org.overmind.doucounter.feed.RSSFeedParser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:52
 */
public class RSSFeedParserTest {

    private RSSFeedParser rssFeedParser;

    @Before
    public void setUp() throws Exception {
        this.rssFeedParser = RSSFeedParser.create("http://www.vogella.com/article.rss");
    }

    @Test
    public void readFeed() throws Exception {
        final Feed feed = rssFeedParser.readFeed();
        assertNotNull(feed);
        assertFalse(
                feed.getEntries()
                        .isEmpty()
        );
    }
}