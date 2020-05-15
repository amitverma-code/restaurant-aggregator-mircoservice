package com.cts.model.restaurant1;

import java.util.ArrayList;
import java.util.List;




public class Menu {

	
	private Integer id;
	
	
	private List<Items> items;

	public Menu(Integer id, List<Items> items) {
		super();
		this.id = id;
		this.items = items;
	}

	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", items=" + items + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	
}