package com.london.food.service;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.london.food.mappers.Location;
import com.london.food.mappers.LocationJson;
import com.london.food.mappers.PizzaPlaceJson;

public class PizzaPlaceAPIService {

protected String urlPostCode, urlPizzaPlace, googleAPIKey;

	
	public PizzaPlaceAPIService(String urlPostCode, String urlPizzaPlace, String googleAPIKey) {
		this.urlPostCode = urlPostCode;
		this.urlPizzaPlace = urlPizzaPlace;
		this.googleAPIKey = googleAPIKey;
	}

	public PizzaPlaceJson readFromUrl(Map<String, String> params) {
		
		RestTemplate restTemplate = new RestTemplate();

		LocationJson resultLocation = restTemplate.getForObject(urlPostCode, LocationJson.class, params);
		Location location = resultLocation.getResult();
		
		Double latitude = location.getLatitude();
		Double longitude = location.getLongitude();

		
		params.put("location", latitude.toString() + "," + longitude.toString());
		params.put("googleAPIKey", googleAPIKey);

		return restTemplate.getForObject(urlPizzaPlace, PizzaPlaceJson.class, params);
	}
}
