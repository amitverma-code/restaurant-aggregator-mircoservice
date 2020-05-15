package com.cts.model;


public class AggregatorItems {


	private String Name;
	private String desc;
	private String notes;
	private AggregatorPrice price;
	public AggregatorItems() {
		// TODO Auto-generated constructor stub
	}
	
	public AggregatorItems(String name, String desc, String notes, AggregatorPrice price) {
		super();
		Name = name;
		this.desc = desc;
		this.notes = notes;
		this.setPrice(price);
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public AggregatorPrice getPrice() {
		return price;
	}

	public void setPrice(AggregatorPrice price) {
		this.price = price;
	}
	
		
}