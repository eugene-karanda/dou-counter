package org.overmind.doucounter.feed;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:11
 */
public class RSSFeedParserJAXBTest {

    private RSSFeedParserJAXB rssFeedParserJAXB;

    @Before
    public void setUp() throws Exception {
        this.rssFeedParserJAXB = RSSFeedParserJAXB.create(getClass().getResourceAsStream("/atom-feed.xml"));
    }

    @Test
    public void readFeed() throws Exception {
        final Feed actual = rssFeedParserJAXB.parse();

        assertEquals(
                new Feed(
                        new Channel(
                                "Eclipse and Android Information",
                                "http://www.vogella.com",
                                "Eclipse and Android Information",
                                "en",
                                "Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Germany (CC BY-NC-SA 3.0)",
                                "Tue, 03 May 2016 11:46:11 +0200",
                                Arrays.asList(
                                        new FeedMessage(
                                                "Android user interface testing with Espresso - Tutorial",
                                                "This tutorial describes how to test Android applications with the Android Espresso testing framework.",
                                                "http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html",
                                                "lars.vogel@vogella.com (Lars Vogel)",
                                                "http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html"
                                        ),
                                        new FeedMessage(
                                                "Using the Gradle build system in the Eclipse IDE - Tutorial",
                                                "This article describes how to use the Gradle tooling in Eclipse",
                                                "http://www.vogella.com/tutorials/EclipseGradle/article.html",
                                                "lars.vogel@vogella.com (Lars Vogel)",
                                                "http://www.vogella.com/tutorials/EclipseGradle/article.html"
                                        )
                                )
                        )
                ),
                actual
        );

    }
}