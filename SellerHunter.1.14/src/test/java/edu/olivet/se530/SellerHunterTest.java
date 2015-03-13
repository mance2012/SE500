package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

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
	
	@Test public void test_get_offer_list_0907871496() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer("0907871496", "New");
		Assert.assertEquals("the_book_depository_", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list_751515736() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer("751515736", "Used");
		Assert.assertEquals("Free State Books", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list_1416532277() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer("1416532277", "New");
		Assert.assertEquals("BookSeller USA, LLC", offer.getSeller().getName());
	}
	
	@Test public void test_get_offer_list_135157862() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer("135157862", "New");
		Assert.assertEquals("AP", offer.getSeller().getName());
	}
	
	
	@Test public void test_get_offer_orderby_price_751515736() throws MalformedURLException, IOException {
		Offer offer_old = hunter.huntOffer("751515736", "Used");
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