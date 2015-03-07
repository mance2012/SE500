package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import edu.olivet.se530.SellerHunter;
import edu.olivet.se530.model.Offer;

/**
 * Seller猎手
 */
public class SellerHunterEntry {
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		SellerHunter hunter = new SellerHunter();
		Offer offer = hunter.huntOffer("0751515736", "Used");
		System.out.println(offer);
	}	
}
