package com.cts.model.restaurant1;

public class Price  {
	
	private double cgst;
	private double sgst;
	private Integer basePrice;
	
	private double totalPrice;
	public Price(double cgst, double sgst, Integer basePrice, double totalPrice) {
		super();
		this.cgst = cgst;
		this.sgst = sgst;
		this.basePrice = basePrice;
		this.totalPrice = totalPrice;
	}
	public double getCgst() {
		return cgst;
	}
	public void setCgst(double cgst) {
		this.cgst = cgst;
	}
	public double getSgst() {
		return sgst;
	}
	public void setSgst(double sgst) {
		this.sgst = sgst;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
public Price() {
	// TODO Auto-generated constructor stub
}
public Integer getBasePrice() {
	return basePrice;
}
public void setBasePrice(Integer basePrice) {
	this.basePrice = basePrice;
}
	
}