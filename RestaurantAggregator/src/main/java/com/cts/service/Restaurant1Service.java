package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cts.model.AggregatorItems;
import com.cts.model.AggregatorMenu;
import com.cts.model.AggregatorPrice;
import com.cts.model.restaurant1.Items;
import com.cts.model.restaurant1.Menu;
import com.cts.properties.AppProperties;

public class Restaurant1Service {

	@Autowired
	AppProperties appProperties;
	@Autowired
	RestTemplate restTemplate;
	public AggregatorMenu getMenu(){
		AggregatorMenu aggregatorMenu=null;
		Menu menu = restTemplate.getForObject(""+appProperties.getMenurestaurant1(), Menu.class);
		List<Items> itemsList=menu.getItems();
		aggregatorMenu =new AggregatorMenu();
		List<AggregatorItems> aggregatorItems=new ArrayList<AggregatorItems>();
	    for(Items i:itemsList) {
			AggregatorItems items=new AggregatorItems();
			AggregatorPrice aggregatorPrice=new AggregatorPrice();
			items.setName(i.getItemName());
			items.setDesc(i.getDesc());
			items.setNotes(String.valueOf(i.getRating()));
			aggregatorPrice.setCgst(i.getPrice().getCgst());
			aggregatorPrice.setSgst(i.getPrice().getSgst());
			aggregatorPrice.setTotalPrice(i.getPrice().getTotalPrice());
			items.setPrice(aggregatorPrice);
			aggregatorItems.add(items);
		}
		aggregatorMenu.setItems(aggregatorItems);
		return aggregatorMenu;
	}
}


//Menu menu = restTemplate.getForObject("http://localhost:9090/restaurant/1399/menu", Menu.class);
	//List<Items> itemsList=menu.getItems();
	//aggregatorMenu =new AggregatorMenu();
	//List<AggregatorItems> aggregatorItems=new ArrayList<AggregatorItems>();
  //  for(Items i:itemsList) {
	//	AggregatorItems items=new AggregatorItems();
	//	AggregatorPrice aggregatorPrice=new AggregatorPrice();
	//	items.setName(i.getItemName());
	//	items.setDesc(i.getDesc());
	//	items.setNotes(String.valueOf(i.getRating()));
	//	aggregatorPrice.setCgst(i.getPrice().getCgst());
	//	aggregatorPrice.setSgst(i.getPrice().getSgst());
	//	aggregatorPrice.setTotalPrice(i.getPrice().getTotalPrice());
	//	items.setPrice(aggregatorPrice);
	//	aggregatorItems.add(items);
	//}
	//aggregatorMenu.setItems(aggregatorItems);
	// fetch using url for 1399
	//we have to use properties 
	//invoke the url
	//map the response to the menu.java for restr 1399
	//this menu.java is compile version of tha pojo from 1399 swagger file
	//covert this menu.java into aggregator's menu.java(this conversion is knowns as transformation)
