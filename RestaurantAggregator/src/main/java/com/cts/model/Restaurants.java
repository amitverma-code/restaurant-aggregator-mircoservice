package com.cts.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurants {
	private String restaurantId;
	
	private String restaurantName;
	
	private String restaurantAddress;
	
    private String restaurantOwner;
	
    private String restaurantType;
	
    private String restaurantRating;

	public Restaurants(String restaurantId, String restaurantName, String restaurantAddress, String restaurantOwner,
			String restaurantType, String restaurantRating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantOwner = restaurantOwner;
		this.restaurantType = restaurantType;
		this.restaurantRating = restaurantRating;
	}

	public Restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantOwner=" + restaurantOwner
				+ ", restaurantType=" + restaurantType + ", restaurantRating=" + restaurantRating + "]";
	}
    
  
    
}
