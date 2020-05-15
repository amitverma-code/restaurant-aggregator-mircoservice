package com.cts.model.restaurant2;

import java.util.List;

public class Menu {
	private Integer id;
	private List<Item> item;
	private transient String message;
	public Menu(Integer id, List<Item> item, String message) {
		super();
		this.id = id;
		this.item = item;
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
