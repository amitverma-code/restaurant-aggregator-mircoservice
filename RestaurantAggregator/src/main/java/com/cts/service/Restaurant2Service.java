package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cts.model.AggregatorItems;
import com.cts.model.AggregatorMenu;
import com.cts.model.AggregatorPrice;
import com.cts.model.restaurant2.Item;
import com.cts.model.restaurant2.Menu;
import com.cts.properties.AppProperties;

public class Restaurant2Service {
	@Autowired
	AppProperties appProperties;
	@Autowired
	RestTemplate restTemplate;
	public AggregatorMenu getMenu(){
		AggregatorMenu aggregatorMenu=null;
		Menu menu = restTemplate.getForObject(""+appProperties.getMenurestaurant2(), Menu.class);
		List<Item> itemsList=menu.getItem();
		aggregatorMenu =new AggregatorMenu();
		List<AggregatorItems> aggregatorItems=new ArrayList<AggregatorItems>();
	    for(Item i:itemsList) {
			AggregatorItems items=new AggregatorItems();
			AggregatorPrice aggregatorPrice=new AggregatorPrice();
			items.setName(i.getItemName());
			items.setDesc(i.getItemDescription());
			items.setNotes(i.getIngredients());
			aggregatorPrice.setCgst(i.getPrice().getGst());
			aggregatorPrice.setBasePrice((i.getPrice().getBasePrice()));
			aggregatorPrice.setTotalPrice(i.getPrice().getTotalPrice());
			items.setPrice(aggregatorPrice);
			aggregatorItems.add(items);
		}
		aggregatorMenu.setItems(aggregatorItems);
		return aggregatorMenu;
	}
}
