package com.london.food.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.london.food.mappers.Location;
import com.london.food.mappers.PizzaPlaceJson;

public class PizzaPlaceAPIService {

protected String urlPizzaPlace, googleAPIKey;

	@Autowired
	private PostCodeLocationService postalCodeLocationService;
	
	public PizzaPlaceAPIService(String urlPizzaPlace, String googleAPIKey) {
		this.urlPizzaPlace = urlPizzaPlace;
		this.googleAPIKey = googleAPIKey;
	}

	public PizzaPlaceJson readFromUrl(Map<String, String> params) {
		
		Location location = postalCodeLocationService.getLocationFromPostalCode(params);
		
		params.put("location", location.getLatitude().toString() + "," + location.getLongitude().toString());
		params.put("googleAPIKey", googleAPIKey);
		
		return new RestTemplate().getForObject(urlPizzaPlace, PizzaPlaceJson.class, params);
	}
}
