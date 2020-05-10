package com.cts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cts.model.Restaurants;
import com.cts.model.RestaurantMenu;
import com.cts.service.MenuService;


 
    @RestController
    public class AggregatorController {
    	
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    MenuService menuService;
    
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public List<Restaurants> getRestaurants(){
     return menuService.getAllRestaurant();
    }
    
    @RequestMapping(value = "/restaurant/{id}/menu")
    public RestaurantMenu getMenu(@PathVariable String id) 
    {
    return menuService.getMenuDetails(id);
    }
}

    
    
  