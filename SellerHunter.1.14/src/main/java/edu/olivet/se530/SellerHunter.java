package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Product;

@Singleton
public class SellerHunter {
	@Inject private HtmlCrawler htmlFetcher;
	@Inject private HtmlParser htmlParser;
	private List<Offer> Offers;
	
	/**
	 * 根据给定的isbn和condition，返回亚马逊网站上面的Offer列表
	 * @param isbn		产品的ISBN编号，参见:{@link Product#getIsbn()}
	 * @param condition	产品的Condition
	 */
	public Offer huntOffer(String isbn, String condition) throws MalformedURLException, IOException {
		Document doc = htmlFetcher.getDocument(isbn, condition);
		List<Offer> offers = htmlParser.parseOffer(doc);
		
		for (Iterator<Offer> iterator = offers.iterator(); iterator.hasNext();) {
			Offer offer = iterator.next();
			if (!this.evaluteRating(offer)) {
				iterator.remove();
			}
			if (!this.evaluteRatingCount(offer)) {
				iterator.remove();
			}
//			if(this.evaluteShippingcountry(offer)) {
//				iterator.remove();
//			}
		}
		
		Collections.sort(offers);
		setOffers(offers);
		return offers.get(0);
		
	}

	/**
	 * 对一个Offer按照价格、运费、Rating和发货地等等标准进行审查
	 * @param offer
	 */
	public boolean evaluteRating(Offer offer) {
		return offer.getSeller().getRating() > 95;
	}

	public boolean evaluteRatingCount(Offer offer) {
		return offer.getSeller().getRatingCount() > 100;
	}
	
	public boolean evaluteShippingcountry(Offer offer) {
		return offer.getSeller().getShippingCountry().equalsIgnoreCase("United Kingdom");
	}

	public void setHtmlFetcher(HtmlCrawler htmlFetcher) {
		this.htmlFetcher = htmlFetcher;
	}

	public void setHtmlParser(HtmlParser htmlParser) {
		this.htmlParser = htmlParser;
	}

	public List<Offer> getOffers() {
		return Offers;
	}

	public void setOffers(List<Offer> offers) {
		Offers = offers;
	}
}