package org.overmind.doucounter.feed;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.10.2017 2:40
 */
public interface RSSFeedParser {

    Feed parse() throws RSSFeedParsingException;
}
