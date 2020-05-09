package com.cts.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.model.Menu;
import com.cts.model.Restaurants;
import com.cts.model.RestaurantMenu;



@Service
//@ConfigurationProperties(prefix="list")
public class MenuService {
	
	
	 @Autowired
	    RestTemplate restTemplate;
  private String url;
  
  public String getAllRestaurant(){
	  HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      return restTemplate.exchange("http://RESTAURANTS-SERVICE/restaurants", HttpMethod.GET,entity,String.class).getBody();
	}
  
  public RestaurantMenu getMenuDetails(String id){
	  Restaurants restaurants = restTemplate.getForObject("http://RESTAURANTS-SERVICE/restaurants"+id, Restaurants.class);
	  if(restaurants!= null) {
      Menu menu = restTemplate.getForObject("http://ABC/restaurants/"+id+"/menu", Menu.class);
      
      return new RestaurantMenu(restaurants.getRestaurantId(),restaurants.getRestaurantName(),menu.getId(),menu.getItemName(),menu.getPrice(),menu.getDesc(),menu.getRating());
	}
	  else {
		   RestaurantMenu restaurantMenu = new RestaurantMenu(null,null,null,null,null,null,null);
		   return restaurantMenu;
	  }
  }
}
