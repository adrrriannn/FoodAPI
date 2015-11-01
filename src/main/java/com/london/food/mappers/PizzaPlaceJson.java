package com.london.food.mappers;

import java.util.Arrays;

public class PizzaPlaceJson {
	
	private PizzaPlace[] results;

	public PizzaPlace[] getResults() {
		return results;
	}

	public void setResults(PizzaPlace[] results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(results);
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
		PizzaPlaceJson other = (PizzaPlaceJson) obj;
		if (!Arrays.equals(results, other.results))
			return false;
		return true;
	}

}
