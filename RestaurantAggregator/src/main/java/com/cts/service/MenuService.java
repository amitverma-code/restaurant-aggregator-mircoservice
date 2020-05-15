package com.cts.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.model.restaurant1.Items;
import com.cts.model.restaurant1.Menu;
import com.cts.model.Restaurants;
import com.cts.properties.AppProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.cts.model.AggregatorItems;
import com.cts.model.AggregatorMenu;
import com.cts.model.AggregatorPrice;

    @Service
    public class MenuService {
	
	
	@Autowired
	AppProperties appProperties;
	
	@Autowired
	Restaurant1Service restaurant1Service;
	
	@Autowired
	Restaurant2Service restaurant2Service;
	@Autowired
	RestTemplate restTemplate;
	public List<Restaurants> getAllRestaurant(){
    ResponseEntity<Restaurants[]> responseEntity = restTemplate.getForEntity(""+appProperties.getFullList(), Restaurants[].class);
	return Arrays.asList(responseEntity.getBody());
	}
	
  
    @HystrixCommand(fallbackMethod="getfallbackMenuDetails")
    public AggregatorMenu  getMenuDetails(String id){
	Restaurants restaurants = restTemplate.getForObject(""+appProperties.getById(), Restaurants.class);
	AggregatorMenu aggregatorMenu=null;
	if (restaurants!= null){
	
	if(id.equalsIgnoreCase("1399")) {
		
		restaurant1Service.getMenu();
	
	}
	else if(id.equalsIgnoreCase("5599")) {
		restaurant2Service.getMenu();
	}
	else {
		return null;
		//here we have to return string as menu not present for restaurant +id;
	}
	return aggregatorMenu;
	
	}
	else
	{
		return null;
		//here we have use exception and return string as restaurant not present in database +id
	}
	}
    
    public AggregatorMenu getfallbackMenuDetails(String id) {
   	return null;
     }
	}

	 
	
	
	//if(restaurants!= null) {
   // Menu menu = restTemplate.getForObject(""+appProperties.getMenu()+id+"/menu", Menu.class);
    // Menu menu = restTemplate.getForObject("localhost:abc/restaurant/"+id+"/menu", Menu.class);
    //using id we have to fetch menu.So map restaurant with menu using restaurant's id.
   // return new RestaurantMenu(restaurants.getRestaurantId(),restaurants.getRestaurantName(),menu.getId(),menu.getItemName(),menu.getPrice(),menu.getDesc(),menu.getRating());
	//}
	//else 
	//{
  //  RestaurantMenu restaurantMenu = new RestaurantMenu("not found",null,null,null,null,null,null);
  //  return restaurantMenu;
///	}
 // }
   // public RestaurantMenu getfallbackMenuDetails(String id) {
  //	return new RestaurantMenu("Server Down","not found","not found","not found","not found","not found","not found");
   // }
