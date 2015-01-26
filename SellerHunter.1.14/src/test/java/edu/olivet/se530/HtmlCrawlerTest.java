package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

public class HtmlCrawlerTest {
	private HtmlCrawlerImpl htmlCrawler = new HtmlCrawlerImpl();
	private String isbn = "031043601X";
	private String condition = "New";
	
	@Test public void test_get_text() throws MalformedURLException, IOException {
		Document document = htmlCrawler.getDocument(isbn, condition);
		String selector = "#olpTabContent > div > div.a-section.a-spacing-double-large > div:nth-child(5) > div.a-column.a-span2.olpSellerColumn > p:nth-child(2) > a > b";
		Assert.assertTrue(document.select(selector).size() > 0);
	}

}
