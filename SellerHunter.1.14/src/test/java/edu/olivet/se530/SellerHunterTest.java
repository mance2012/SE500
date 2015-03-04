package edu.olivet.se530;

import java.io.IOException;
import java.net.MalformedURLException;

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
	private String isbn = "0751515736";
	private String condition = "Used";
	
	@Test public void test_get_offer_list() throws MalformedURLException, IOException {
		Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertEquals("Free State Books", offer.getSeller().getName());
	}
}