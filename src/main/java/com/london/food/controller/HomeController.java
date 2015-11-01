package com.london.food.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.london.food.exception.ValidationException;
import com.london.food.mappers.PizzaPlaceJson;
import com.london.food.request.PizzaRequest;
import com.london.food.response.PizzaResponse;
import com.london.food.response.Response;
import com.london.food.service.PizzaPlaceAPIService;
import com.london.food.validator.PostCodeValidator;

@RestController
public class HomeController extends ParentController {

	@Autowired
	private PizzaPlaceAPIService pizzaPlaceAPIService;
	@Autowired
	private PostCodeValidator postCodeValidator;

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public Response pizza(@RequestParam(value = "postcode") String postcode){
		
		try {
			postCodeValidator.validate(postcode);
		} catch (ValidationException e) {
			return buildResponse(false, e.getMessage());
		}
		
		Map<String, String> params = new HashMap<>();
		params.put("postcode", postcode);
		PizzaPlaceJson json = pizzaPlaceAPIService.readFromUrl(params);
		PizzaResponse resp = new PizzaResponse();
		resp.setSuccess(true);
		resp.setPizzaJson(json);
		return resp;
	}
}