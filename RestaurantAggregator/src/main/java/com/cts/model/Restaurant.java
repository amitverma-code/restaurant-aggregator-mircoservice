package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Restaurant{
	private String restaurantId;
	private String restaurantName;
	private String restaurantAddress;
    private String restaurantOwner;
    private String restaurantType;
    private String restaurantRating;
    
}