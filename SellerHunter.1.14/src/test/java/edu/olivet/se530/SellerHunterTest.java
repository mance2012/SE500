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
	private String isbn = "0907871496";
	private String condition = "New";
	
	@Test public void test_get_offer_list() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertEquals("the_book_depository_", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list2() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer("751515736", "Used");
		Assert.assertEquals("Free State Books", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list3() throws MalformedURLException, IOException {
		//1416532277	New			BookSeller USA, LLC
		Offer offer = hunter.huntOffer("1416532277", "New");
		Assert.assertEquals("BookSeller USA, LLC", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list4() throws MalformedURLException, IOException {
		//135157862	New			AP
		Offer offer = hunter.huntOffer("135157862", "New");
		Assert.assertEquals("AP", offer.getSeller().getName());
	}
	
	
	@Test public void test_get_offer_rating() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertTrue(offer.getSeller().getRating() > 95);
	}	
	
	@Test public void test_get_offer_rating_count() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertTrue(offer.getSeller().getRatingCount() > 100);
	}	
	

	@Test public void test_get_offer_orderby_price() throws MalformedURLException, IOException {
		Offer offer_old = hunter.huntOffer("135157862", "New");
		boolean ordered = true;
		
		for (Iterator<Offer> iterator = hunter.getOffers().iterator(); iterator.hasNext();) {
			Offer offer_new = iterator.next();

			if(offer_new.getPrice() + offer_new.getFilteredShippingPrice() - offer_old.getPrice() - offer_old.getFilteredShippingPrice() < 0) {
				ordered = false;
			}
			offer_old = offer_new;
		}
		Assert.assertTrue(ordered);
	}
	
	
	

}