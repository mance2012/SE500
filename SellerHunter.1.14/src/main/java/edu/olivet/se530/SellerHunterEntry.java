package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.google.inject.Guice;

import edu.olivet.se530.SellerHunter;
import edu.olivet.se530.model.Offer;

/**
 * Seller猎手
 */
public class SellerHunterEntry {

	public static void main(String[] args) throws MalformedURLException, IOException {
		SellerHunter hunter = Guice.createInjector(new CrawlerModule()).getInstance(SellerHunter.class);
		Offer offer = hunter.huntOffer("907871496", "New");
		System.out.println(offer.getSeller().getName());
	}	
}
