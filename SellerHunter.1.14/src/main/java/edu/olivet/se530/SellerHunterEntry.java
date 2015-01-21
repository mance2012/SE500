package edu.olivet.se530;
import java.util.List;
import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import edu.olivet.se530.model.Offer;

/*
 * Seller 猎手
 */

public class SellerHunterEntry {

	public static void main(String[] args) throws IOException {
		SellerHunter hunter = new SellerHunter();
		List<Offer> offers = hunter.getOfferList("031043601X", "New");
		for (Offer offer : offers) {
			System.out.println(offer);
		}
			
	}

}
