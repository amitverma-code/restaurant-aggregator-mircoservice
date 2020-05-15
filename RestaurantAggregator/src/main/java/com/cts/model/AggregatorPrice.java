package com.cts.model;

public class AggregatorPrice  {
	private double basePrice;
	private double cgst;
	private double sgst;
	
	
	public AggregatorPrice(double basePrice, double cgst, double sgst, double totalPrice) {
		super();
		this.basePrice = basePrice;
		this.cgst = cgst;
		this.sgst = sgst;
		this.totalPrice = totalPrice;
	}
	private double totalPrice;
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
	
public AggregatorPrice() {
	// TODO Auto-generated constructor stub
}
public double getBasePrice() {
	return basePrice;
}
public void setBasePrice(double basePrice) {
	this.basePrice = basePrice;
}
	
}