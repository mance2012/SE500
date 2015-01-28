package edu.olivet.se530;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.olivet.se530.model.Condition;
import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;

public class HtmlParser {
	
	public  List<Offer> parserOffer(Document doc){
		List<Offer> results = new ArrayList<Offer>();
		Elements rows = doc.select("div.a-row.a-spacing-mini.olpOffer");
		for (int i = 0; i < rows.size(); i++) {
			Offer offer = new Offer();
			Element row = rows.get(i);
			
			Seller seller = new Seller();
			String SellerNameSellector = "p.a-spacing-samll.olpSellerName";
			seller.setName(this.getText(row, SellerNameSellector));
			Elements link = rows.select(SellerNameSellector + "a");
			if( link.size() > 0) {
				seller.setUuid(link.get(0).attr("href").replaceFirst(".*&seller=", ""));
			}
			
			
			offer.setPrice(Float.parseFloat(this.getText(row, "span.olpOfferPrice").replace("$", "")));
			String shippingFeeText = this.getText(row, "span.olpShippingPrice").replace("$", "");
			//需要再次进行处理
			if(shippingFeeText != null && shippingFeeText.trim().length() > 0) {
				offer.setPrice(Float.parseFloat(shippingFeeText));
			}

			String cond = this.getText(row, "h3.a-spacing-small olpCondition");
			String[] array = cond.split("-");
			Condition condition = new Condition();
			condition.setPrimary(array[0].trim());
			//condition.setSecondary(array[1].trim());
			
			offer.setSeller(seller);
			offer.setCondition(condition);
			results.add(offer);
		}
		return results;
	}

	public String getText(Element element, String selector) {
		Elements elements = element.select(selector);
		if(elements.size() <= 0){
			return "";
		}
		return elements.get(0).text();
	}
}
