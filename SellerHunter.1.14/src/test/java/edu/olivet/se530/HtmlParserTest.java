package edu.olivet.se530;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.olivet.se530.HtmlParser;
import edu.olivet.se530.dummy.DummyHtmlCrawler;
import edu.olivet.se530.model.Offer;


public class HtmlParserTest {
	private HtmlParser htmlParser = new HtmlParser();
	private static Document document;
	
	@BeforeClass public static void prepareDocument() throws MalformedURLException, IOException{
		document = new DummyHtmlCrawler().getDocument("","");
	}
	
	@Test
	public void testParseOffer() {
		List<Offer> offers = htmlParser.parserOffer(document);
		Assert.assertTrue(6.99f == offers.get(0).getPrice());
		Assert.assertEquals("", offers.get(1).getCondition().getPrimary());
		//Assert.assertEquals("", offers.get(1).getCondition().getSecondary());
		
	}
	
	@Test
	public void testGetText() {
		Assert.assertEquals("indoobestsellers", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span2.olpSellerColumn > p.a-spacing-small.olpSellerName > span > a"));
		Assert.assertEquals("In Stock.", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(7) > div.a-column.a-span3.olpDeliveryColumn > ul > li:nth-child(1) > span"));
		Assert.assertEquals("Amazon Prime TM", htmlParser.getText(document, "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(3) > div:nth-child(1) > span.supersaver > i > span"));
	}

}
