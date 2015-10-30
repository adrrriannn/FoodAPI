package com.london.food.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.london.food.mappers.PizzaPlaceJson;
import com.london.food.service.PizzaPlaceAPIService;
import com.london.food.validator.PostCodeValidator;

@RestController
public class HomeController extends ParentController {

	@Autowired
	private PizzaPlaceAPIService pizzaPlaceAPIService;
	
//	@Autowired
	protected PostCodeValidator postCodeValidator;
	
	@InitBinder("postcode")
	public void initBinderPostCodek(WebDataBinder binder) {
		binder.setValidator(new PostCodeValidator());
	}	

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public PizzaPlaceJson pizza(@RequestParam("postcode") String postcode) {

		Map<String, String> params = new HashMap<>();
		params.put("postcode", postcode);
		PizzaPlaceJson json = pizzaPlaceAPIService.readFromUrl(params);

		return json;
	}

}