package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.olivet.se530.dummy.DummyModule;
import edu.olivet.se530.model.Offer;
 
@RunWith(JukitoRunner.class)
@UseModules(value = DummyModule.class)
public class SellerHunterTest {
	@Inject private SellerHunter hunter;
	private String isbn = "0813343585";
	private String condition = "NEW";
	
	@Test public void test_get_offer_list() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		System.out.print(offer.getSeller().getName());
		Assert.assertEquals("aHALL078", offer.getSeller().getName());
	}
	
	
	@Test public void test_get_offer_rating() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertTrue(offer.getSeller().getRating() > 95);
	}	
	
	@Test public void test_get_offer_rating_count() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertTrue(offer.getSeller().getRatingCount() > 100);
	}	
	

	@Test public void test_get_offer_shipping() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertTrue(offer.getSeller().getShippingCountry() != "United Kingdom");
	}
	
	@Test public void test_get_offer_orderby_price() throws MalformedURLException, IOException {
		Offer offer_old = hunter.huntOffer(isbn, condition);
		boolean ordered = true;
		
		for (Iterator<Offer> iterator = hunter.getOffers().iterator(); iterator.hasNext();) {
			Offer offer_new = iterator.next();
			if(offer_new.getPrice() + offer_new.getFilteredShippingPrice() - offer_old.getPrice() - offer_old.getFilteredShippingPrice() < 0) {
				ordered = false;
			}
			offer_old = offer_new;
		}
		Assert.assertTrue(ordered);
		//Assert.assertTrue(offer.getPrice()+offer.getShippingPrice() == 4.76f);
	}
	
//	@Test public void test_get_offer_orderby_rating() throws MalformedURLException, IOException {
//		Offer offer_old = hunter.huntOffer(isbn, condition);
//		boolean ordered = true;
//		
//		for (Iterator<Offer> iterator = hunter.getOffers().iterator(); iterator.hasNext();) {
//			Offer offer_new = iterator.next();
//			System.out.println(offer_old.getSeller().getRating());
//			if(offer_new.getSeller().getRating() - offer_old.getSeller().getRating() > 0) {
//				ordered = false;
//			}
//			offer_old = offer_new;
//		}
//		Assert.assertTrue(ordered);
//		//Assert.assertTrue(offer.getPrice()+offer.getShippingPrice() == 4.76f);
//	}
	
	

}