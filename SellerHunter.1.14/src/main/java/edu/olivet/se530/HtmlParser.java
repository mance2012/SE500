package edu.olivet.se530;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;

public class HtmlParser {
	
	public  List<Offer> parserOffer(Document doc){
		List<Offer> results = new ArrayList<Offer>();
		Elements rows = doc.select("div.a-row.a-spacing-mini.olpOffer");
		for (int i = 0; i < rows.size(); i++) {
			Offer offer = new Offer();
			Seller seller = new Seller();
			seller.setName(this.getText(doc, ""));
			offer.setSeller(seller);
			results.add(offer);
		}
		return results;
	}

	public String getText(Document document, String selector) {
		Elements elements = document.select(selector);
		if(elements.size() <= 0){
			return "";
		}
		return elements.get(0).text();
	}
}
