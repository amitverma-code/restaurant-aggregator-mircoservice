package com.cts.model.restaurant2;

public class Item {
	private Integer itemId;
	private String itemName;
	private String itemDescription;
	private String ingredients;
	private Type type;
	private Price price;
	public Item(Integer itemId, String itemName, String itemDescription, String ingredients, Type type, Price price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.ingredients = ingredients;
		this.type = type;
		this.price = price;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
