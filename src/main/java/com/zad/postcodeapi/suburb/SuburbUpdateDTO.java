package com.zad.postcodeapi.suburb;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class SuburbUpdateDTO {

	@Getter
	@Setter
	@Pattern(regexp = "^(?=\\S).*$", message = "Name cannot be empty")
	private String name;

	@Getter
	@Setter
	private Integer population;

	@Getter
	@Setter
	@Pattern(regexp = "^(?=\\S).*$", message = "Postcode cannot be empty")
	private String postcode;

}
