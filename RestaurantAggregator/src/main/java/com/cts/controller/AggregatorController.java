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
import com.cts.model.Restaurants;
import com.cts.model.RestaurantMenu;
import com.cts.service.MenuService;
//import com.netflix.client.http.HttpHeaders;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

 
@RestController
public class AggregatorController {
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    MenuService menuService;
    
    @RequestMapping(value = "/restaurants")
    public String getData() 
    {
     return menuService.getAllRestaurant();
    }
    @RequestMapping(value = "/restaurant/{id}/menu")
    public RestaurantMenu getMenu(@PathVariable String id) 
    {
     return menuService.getMenuDetails(id);
    }
}

    
    
  