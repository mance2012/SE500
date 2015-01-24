package edu.olivet.se530.model;
/*
 * 
 * 
 */
public class Offer implements Comparable<Offer>{
	
	@Override
	public String toString() {
		return "Offer [seller=" + seller + ", product=" + product + ", price="
				+ price + ", shippingPrice=" + shippingPrice + ", condition="
				+ condition + "]";
	}
	private Seller seller;
	private Product product;
	private float price;
	private float shippingPrice;
	private Condition condition;
	
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public int compareTo(Offer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
