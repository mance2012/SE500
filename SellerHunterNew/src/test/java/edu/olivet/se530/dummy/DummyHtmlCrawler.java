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
		// TODO Auto-generated method stub
		return Jsoup.parse(new File("D:/JavaClass/SellerHunter.1.14/NIV.html"), "UTF-8");
	}

	
	public String getText(Document doc, String string) {
		// TODO Auto-generated method stub
		return "Goldie's Goodies";
	}

}
