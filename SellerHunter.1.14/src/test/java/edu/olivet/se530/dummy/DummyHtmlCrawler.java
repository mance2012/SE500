package edu.olivet.se530.dummy;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.olivet.se530.HtmlCrawler;

public class DummyHtmlCrawler implements HtmlCrawler {

	public Document getDocument(String isbn, String condition)
			throws MalformedURLException, IOException {
		String _isbn = StringUtils.leftPad(isbn, 10, '0');
		String fileName = String.format("%s_%s_1.html", _isbn, condition.split("-")[0].trim().toUpperCase());
		return Jsoup.parse(new File("D:/MyJavaProject/SE530/SellerHunter.1.14/Assignment/" + fileName), "UTF-8");
	}

}
