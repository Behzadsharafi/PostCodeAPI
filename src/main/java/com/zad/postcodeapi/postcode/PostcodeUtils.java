package com.zad.postcodeapi.postcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zad.postcodeapi.exceptions.NotFoundException;



@Component
public class PostcodeUtils {
	@Autowired
	private PostcodeService postcodeService;
	
	public Postcode findPostCodeByPostCodeOrElseThrow(int postcode) {
		return this.postcodeService.findPostcodeByPostcodeNumber(postcode)
				.orElseThrow(() -> new NotFoundException(postcode + ": is an invalid postcode"));
	}
	
	public boolean findOutDoesPostcodeExist(int postcode) {
		return this.postcodeService.findPostcodeByPostcodeNumber(postcode).isPresent();
	}
	
	public Postcode findPostCodeByIdOrElseThrow(Long id) {
		return this.postcodeService.findPostcodeById(id)
				.orElseThrow(() -> new NotFoundException(id + ": is an invalid ID"));
	}
}
