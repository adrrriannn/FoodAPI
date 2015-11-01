package com.london.food.response;

import com.london.food.mappers.PizzaPlaceJson;

public class PizzaResponse extends Response {

	private PizzaPlaceJson pizzaJson;
	
	public PizzaResponse(){}
	
	public PizzaResponse(Boolean success, PizzaPlaceJson pizzaJson){
		this.success = success;
		this.pizzaJson = pizzaJson;				
	}

	public PizzaPlaceJson getPizzaJson() {
		return pizzaJson;
	}

	public void setPizzaJson(PizzaPlaceJson pizzaJson) {
		this.pizzaJson = pizzaJson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pizzaJson == null) ? 0 : pizzaJson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaResponse other = (PizzaResponse) obj;
		if (pizzaJson == null) {
			if (other.pizzaJson != null)
				return false;
		} else if (success == null){
			if(other.pizzaJson != null)
				return false;
		} else if (!pizzaJson.equals(other.pizzaJson))
			return false;
		  else if (!success.equals(other.success))
			return false;
		return true;
	}
	
	
}
