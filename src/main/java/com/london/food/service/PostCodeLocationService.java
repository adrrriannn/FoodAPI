package com.london.food.service;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.london.food.mappers.Location;
import com.london.food.mappers.LocationJson;

public class PostCodeLocationService {
	
	private String urlPostCodeAPI;

	public PostCodeLocationService(String urlPostCodeAPI){
		this.urlPostCodeAPI = urlPostCodeAPI;
	}
	
	public String getUrlPostCodeAPI() {
		return urlPostCodeAPI;
	}

	public void setUrlPostCodeAPI(String urlPostCodeAPI) {
		this.urlPostCodeAPI = urlPostCodeAPI;
	}
	
	public Location getLocationFromPostalCode(Map<String, String> params){
		
		Location location = new RestTemplate()
								.getForObject(urlPostCodeAPI, LocationJson.class, params)
								.getResult();
		
		return location;
	}
}
