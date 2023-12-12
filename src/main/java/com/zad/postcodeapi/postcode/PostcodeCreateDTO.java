package com.zad.postcodeapi.postcode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PostcodeCreateDTO {
	
	@Min(0)
	private int postcode;

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
}
