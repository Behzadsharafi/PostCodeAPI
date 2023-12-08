package com.zad.postcodeapi.suburb;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class SuburbCreateDTO {

	@Getter
	@Setter
	@NotBlank
	private String name;

	@Getter
	@Setter
	@NotNull
	private Integer population;

	@Getter
	@Setter
	@NotBlank
	private String postcode;

	public SuburbCreateDTO(String name, Integer population, String postcode) {
		this.name = name;
		this.population = population;
		this.postcode = postcode;
	}

}
