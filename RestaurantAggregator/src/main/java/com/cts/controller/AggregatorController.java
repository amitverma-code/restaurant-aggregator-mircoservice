package com.cts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cts.model.Restaurant;
//import com.netflix.client.http.HttpHeaders;
 
@RestController
public class AggregatorController {
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value = "/restaurants")
    public String getData() 
    {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity <String> entity = new HttpEntity<String>(headers);
       return restTemplate.exchange("http://RESTAURANTS-SERVICE/restaurants", HttpMethod.GET,entity,String.class).getBody();
    //returning whole list of restaurants using micro service restaurant list which is using local database
    }
    
    
    @RequestMapping(value = "/restaurants/{name}")
    public String searchRes(@PathVariable String name){
    		HttpHeaders headers = new HttpHeaders();
    	       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	       HttpEntity <String> entity = new HttpEntity<String>(headers);
    	    String restaurantstr  = restTemplate.exchange("http://RESTAURANTS-SERVICE/restaurants/"+name,
    	    		HttpMethod.GET,entity,String.class).getBody();
    	     //return restTemplate.exchange("http://RESTAURANTS-SERVICE/restaurants/"+name, HttpMethod.GET,entity,String.class).getBody();
    	    //getting restaurants by their name using local database of micro service restaurant list 
    	    if(restaurantstr!= null) {
    	Restaurant restaurantModel = new Restaurant();
  Arrays.asList(restaurantModel.getRestaurantId(),
	  restaurantModel.getRestaurantName(),
		 restaurantModel.getRestaurantAddress(),
	 restaurantModel.getRestaurantOwner(),
	 restaurantModel.getRestaurantType(),
	 restaurantModel.getRestaurantRating());
  String restaurant = restaurantModel.getRestaurantName();
  String id = restaurantModel.getRestaurantId();
 return restTemplate.exchange("http://ABC/"+restaurant+"/"+id+"/"+"menu", HttpMethod.GET,entity,String.class).getBody();
 // fetching more details about selected restaurant from using other micro services
    }else {
    	System.out.println("not present");
    	return null;
   }
    }
    
    
   @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
       return new RestTemplate();
    }
}