package edu.olivet.se530.dummy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	public Document getDocument(String isbn, String condition)
			throws MalformedURLException, IOException {
		return Jsoup.parse(new File("D:/MyJavaProject/SE530/SellerHunter.1.14/Assignment/0751515736_USED_1.html"), "UTF-8");
	}

}
