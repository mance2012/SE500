package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;

class SellerHunter {
	private HtmlCrawler htmlFetcher;
	private HtmlParser htmlParser;
	public void setHtmlCrawler(HtmlCrawler htmlCrawler) {
		this.htmlFetcher = htmlCrawler;
	}

	public List<Offer> getOfferList(String isbn, String condition) throws MalformedURLException, IOException {
		Document doc = htmlFetcher.getDocument(isbn, condition);
		List<Offer> results = htmlParser.parserOffer(doc);
		
		return results;
	}
	
	
	
}