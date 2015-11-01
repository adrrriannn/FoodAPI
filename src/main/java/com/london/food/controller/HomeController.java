package com.london.food.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.london.food.exception.ValidationException;
import com.london.food.mappers.PizzaPlaceJson;
import com.london.food.response.ErrorResponse;
import com.london.food.response.PizzaResponse;
import com.london.food.response.Response;
import com.london.food.service.PizzaPlaceAPIService;
import com.london.food.validator.PostCodeValidator;

@RestController
public class HomeController {

	@Autowired
	private PizzaPlaceAPIService pizzaPlaceAPIService;
	@Autowired
	private PostCodeValidator postCodeValidator;

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public Response pizza(@RequestParam(value = "postcode") String postcode){
		
		try {
			postCodeValidator.validate(postcode);
		} catch (ValidationException e) {
			return new ErrorResponse(false, e.getMessage());
		}
		
		Map<String, String> params = new HashMap<>();
		params.put("postcode", postcode);
		PizzaPlaceJson json = pizzaPlaceAPIService.readFromUrl(params);

		return new PizzaResponse(true, json);
	}
}