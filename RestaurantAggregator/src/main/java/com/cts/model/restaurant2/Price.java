package com.cts.model.restaurant2;

public class Price {
	private Integer priceId;
	private double basePrice;
	private double gst;
	private double totalPrice;
	public Price(Integer priceId, double basePrice, double gst, double totalPrice) {
		super();
		this.priceId = priceId;
		this.basePrice = basePrice;
		this.gst = gst;
		this.totalPrice = totalPrice;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
