package com.zad.postcodeapi.suburb;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class SuburbUpdateDTO {
	@Size(min = 1, max = 50)
	private String name;

	@Min(value = 10, message = "Population must be greater than or equal to 10")
	private int population;

	@Min(value = 10, message = "Postcode must be greater than or equal to 10")
	private int postcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
}
