package edu.olivet.se530;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.olivet.se530.annotations.Profile;
import edu.olivet.se530.model.Condition;
import edu.olivet.se530.model.Offer;
import edu.olivet.se530.model.Seller;

public class HtmlParser {
	
	@Profile(desc = "解析一个给定的html document，返回其中的offer列表")
	public List<Offer> parseOffer(Document doc) {
		List<Offer> results = new ArrayList<Offer>();
		Elements rows = doc.select("div.a-row.a-spacing-mini.olpOffer");
		for (int i = 0; i < rows.size(); i++) {
			Element row = rows.get(i);

			Offer offer = new Offer();
			offer.setPrice(Float.parseFloat(this.getText(row, "span.olpOfferPrice").replace("$", "")));
			String shippingFeeText = this.getText(row, "span.olpShippingPrice").replace("$", "");
			if (shippingFeeText != null && shippingFeeText.trim().length() > 0) {
				offer.setShippingPrice(Float.parseFloat(shippingFeeText));
			}
			if(this.hasClass(row, "span.supersaver")) {
				offer.setIsprime(true);
			}
			
			Seller seller = this.parseSeller(row);
			Condition condition = parseCondition(row);
			offer.setSeller(seller);
			offer.setCondition(condition);
			
			results.add(offer);
		}
		
		return results;
	}

	@Profile(desc = "")
	public Condition parseCondition(Element row) {
		String cond = this.getText(row, "h3.a-spacing-small.olpCondition");
		String[] array = cond.split("-");
		Condition condition = new Condition();
		condition.setPrimary(array[0].trim());
		//如果condition只是new的情况，secondary就需要做判断
				if (array.length >= 2) {
					condition.setSecondary(array[1].trim());
				} else {
					condition.setSecondary("");
				}
		return condition;
	}

	@Profile(desc = "")
	public Seller parseSeller(Element row) {
		Seller seller = new Seller();
		String sellerNameSelector = "p.a-spacing-small.olpSellerName";
		seller.setName(this.getText(row, sellerNameSelector));
		Elements link = row.select(sellerNameSelector + "a");
		if( link != null && link.size() > 0) {
			seller.setUuid(link.get(0).attr("href").replaceFirst(".*&seller=", ""));
		}
		
		String ratingText = this.getText(row, "p.a-spacing-small > a > b");
		int rating = Integer.parseInt(ratingText.replaceAll("[^0-9]", ""));
		seller.setRating(rating);
		
		String ratingCountText = this.getText(row, "div.a-column.a-span2.olpSellerColumn > p:nth-child(2)");
		ratingCountText = ratingCountText.substring(ratingCountText.indexOf('('), ratingCountText.indexOf(')')).replaceAll("[^0-9]", "");
		seller.setRatingCount(Integer.parseInt(ratingCountText));
		
		Elements deliveries = row.select("ul.a-vertical > li > span.a-list-item");
		for (int j = 0; j < deliveries.size(); j++) {
			String text = deliveries.get(j).text();
			if (text.contains("Expedited shipping available")) {
				seller.setExpeditedShippingAvailable(true);
			} else if (text.contains("International & domestic shipping rates and return policy")) {
				seller.setIntlShippingAvailable(true);
			} else if (text.matches("Ships from [A-Z]{2}, United States[.]")) {
				String[] array = text.replace("Ships from", "").split(",");
				seller.setShippingState(array[0].trim());
				seller.setShippingCountry(array[1].trim().replace(".", ""));
			}
		}
		return seller;
	}

	@Profile(desc = "")
	public String getText(Element element, String selector) {
		Elements elements = element.select(selector);
		if (elements.size() <= 0) {
			return "";
		}
		return elements.get(0).text();
	}
	
	public boolean hasClass(Element element, String selector) {
		Elements elements = element.select(selector);
		if (elements.size() <= 0) {
			return false;
		}
		return true;
	}
	
}