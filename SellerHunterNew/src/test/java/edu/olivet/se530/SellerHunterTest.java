package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;	
import org.junit.Test;

import edu.olivet.se530.dummy.DummyHtmlCrawler;
import edu.olivet.se530.model.Offer;

public class SellerHunterTest {
	private static SellerHunter hunter;
	String isbn = "031043601X";
	String condition = "New";
	
	@BeforeClass public static void init() {
		hunter = new SellerHunter();
		hunter.setHtmlCrawler(new DummyHtmlCrawler());
	}
	
	@Test public void test_get_offer_list() throws MalformedURLException, IOException {
		List<Offer> offerList = hunter.getOfferList(isbn, condition);
		Assert.assertEquals(10, offerList.size());
		Assert.assertEquals("Goldie's Goodies", offerList.get(1).getSeller().getName());
	}

}
