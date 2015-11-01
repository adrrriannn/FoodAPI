package com.london.food.response;

import com.london.food.mappers.PizzaPlaceJson;

public class PizzaResponse extends Response {

	private PizzaPlaceJson pizzaJson;

	public PizzaPlaceJson getPizzaJson() {
		return pizzaJson;
	}

	public void setPizzaJson(PizzaPlaceJson pizzaJson) {
		this.pizzaJson = pizzaJson;
	}
}
