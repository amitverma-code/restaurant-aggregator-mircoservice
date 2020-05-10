package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
  @EnableEurekaClient
  @SpringBootApplication
  @EnableCircuitBreaker
  public class RestaurantAggregatorApplication {

  public static void main(String[] args) 
  {
  SpringApplication.run(RestaurantAggregatorApplication.class, args);
  }
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() 
  {
  return new RestTemplate();
  }
  }
