package com.cts.model;

import java.util.List;

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
public class Restaurants{
	private String restaurantId;
	private String restaurantName;
	private String restaurantAddress;
    private String restaurantOwner;
    private String restaurantType;
    private String restaurantRating;
    
}