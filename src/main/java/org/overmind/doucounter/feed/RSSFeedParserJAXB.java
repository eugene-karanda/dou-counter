package org.overmind.doucounter.feed;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 08.10.2017 23:41
 */
public final class RSSFeedParserJAXB implements RSSFeedParser {

    private final InputStream is;

    private RSSFeedParserJAXB(InputStream is) {
        this.is = is;
    }

    public static RSSFeedParserJAXB create(URL url) throws IOException {
        return new RSSFeedParserJAXB(url.openStream());
    }

    public static RSSFeedParserJAXB create(String url) throws IOException {
        return create(new URL(url));
    }

    public Feed readFeed() throws RSSFeedParserException {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(Feed.class, Channel.class, FeedMessage.class);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return  (Feed) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            throw new RSSFeedParserException("Exception during reading", e);
        }
    }
}