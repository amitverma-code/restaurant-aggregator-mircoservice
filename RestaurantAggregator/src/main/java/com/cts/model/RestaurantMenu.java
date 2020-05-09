package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class RestaurantMenu {
	private String restaurantId;
	private String restaurantName;
	private String id;
	private String itemName;
	private String price;
	private String desc;
	private String rating;

	public RestaurantMenu(String restaurantId, String restaurantName, String id, String itemName, String price,
			String desc, String rating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.desc = desc;
		this.rating = rating;
	}
	
}
