package edu.olivet.se530;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

public class HtmlCrawlerTest {
	private HtmlCrawlerImpl htmlCrawler;
	String isbn = "031043601X";
	String condition = "New";
	
	@Test
	public void test_get_text() throws MalformedURLException, IOException {
		Document document = htmlCrawler.getDocument(isbn, condition);
		String selector = "#olpTabContent > div > div.a-section.a-spacing-double-large";
		Assert.assertEquals("AP", htmlCrawler.getText(document, selector));
				
	}

}
