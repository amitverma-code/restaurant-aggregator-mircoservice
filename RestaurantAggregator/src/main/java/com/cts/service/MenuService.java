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
	if(restaurants!= null) {
    Menu menu = restTemplate.getForObject(""+appProperties.getMenu()+id+"/menu", Menu.class);
    return new RestaurantMenu(restaurants.getRestaurantId(),restaurants.getRestaurantName(),menu.getId(),menu.getItemName(),menu.getPrice(),menu.getDesc(),menu.getRating());
	}
	else 
	{
    RestaurantMenu restaurantMenu = new RestaurantMenu(null,null,null,null,null,null,null);
    return restaurantMenu;
	}
  }
    public RestaurantMenu getfallbackMenuDetails(String id) {
    	return new RestaurantMenu("Server Down","not found","not found","not found","not found","not found","not found");
    }
}
