package com.cts.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cts.model.Menu;
import com.cts.model.Restaurants;
import com.cts.properties.AppProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.cts.model.RestaurantMenu;

    @Service
    public class MenuService {
	
	
	@Autowired
	AppProperties appProperties;
	
	
	@Autowired
	RestTemplate restTemplate;
	public List<Restaurants> getAllRestaurant(){
    ResponseEntity<Restaurants[]> responseEntity = restTemplate.getForEntity(""+appProperties.getFullList(), Restaurants[].class);
	return Arrays.asList(responseEntity.getBody());
	}
	
  
    @HystrixCommand(fallbackMethod="getfallbackMenuDetails")
    public RestaurantMenu getMenuDetails(String id){
	Restaurants restaurants = restTemplate.getForObject(""+appProperties.getFullList()+"/"+id, Restaurants.class);
	if(id.equalsIgnoreCase("1399")) {
		// fetch using url for 1399
		//we have to use properties 
		//invoke the url
		//map the response to the menu.java for restr 1399
		//this menu.java is compile version of tha pojo from 1399 swagger file
		//covert this menu.java into aggregator's menu.java(this conversion is knowns as transformation)
	}
	else if(id.equalsIgnoreCase("5599")) {
		// fetch using url for 1399
				//we have to use properties 
				//invoke the url
				//map the response to the menu.java for restr 5599
				//this menu.java is compile version of tha pojo from 5599 swagger file
				//covert this menu.java into aggregator's menu.java(this conversion is knowns as transformation)
	}
	
	
	
	
	if(restaurants!= null) {
    Menu menu = restTemplate.getForObject(""+appProperties.getMenu()+id+"/menu", Menu.class);
    // Menu menu = restTemplate.getForObject("localhost:abc/restaurant/"+id+"/menu", Menu.class);
    //using id we have to fetch menu.So map restaurant with menu using restaurant's id.
    return new RestaurantMenu(restaurants.getRestaurantId(),restaurants.getRestaurantName(),menu.getId(),menu.getItemName(),menu.getPrice(),menu.getDesc(),menu.getRating());
	}
	else 
	{
    RestaurantMenu restaurantMenu = new RestaurantMenu("not found",null,null,null,null,null,null);
    return restaurantMenu;
	}
  }
    public RestaurantMenu getfallbackMenuDetails(String id) {
    	return new RestaurantMenu("Server Down","not found","not found","not found","not found","not found","not found");
    }
}
