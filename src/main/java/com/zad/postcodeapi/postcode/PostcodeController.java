package com.zad.postcodeapi.postcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.postcodeapi.exceptions.NotFoundException;
import com.zad.postcodeapi.suburb.Suburb;
import com.zad.postcodeapi.suburb.SuburbService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/postcode")
public class PostcodeController {
	@Autowired
	SuburbService suburbService;

	@Autowired
	PostcodeService postcodeService;

	@Autowired
	PostcodeUtils postcodeUtils;

	@PostMapping
	public ResponseEntity<Postcode> createPostcode(@Valid @RequestBody PostcodeCreateDTO data) {
		Postcode postcode = this.postcodeService.createPostcode(data);
		return new ResponseEntity<Postcode>(postcode, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Postcode>> findAllPostcodes() {
		List<Postcode> allPostcodes = this.postcodeService.findAllPostcodes();
		return new ResponseEntity<List<Postcode>>(allPostcodes, HttpStatus.OK);
	}

	@GetMapping("/find-postcode-by-{suburb}")
	public ResponseEntity<Integer> findPostcodeBySuburbName(@PathVariable String suburb) {
		Suburb foundSuburb = suburbService.findSuburbByName(suburb).orElseThrow(() -> {
			throw new NotFoundException("Could not find a suburb of name: " + suburb);
		});
		return new ResponseEntity<Integer>(foundSuburb.getPostcode(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postcode> findPostcodeById(@PathVariable Long id) {
		return new ResponseEntity<Postcode>(postcodeUtils.findPostCodeByIdOrElseThrow(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Postcode> updatePostcodeById(@PathVariable Long id, @Valid @RequestBody PostcodeUpdateDTO data) {
		Postcode postcode = postcodeUtils.findPostCodeByIdOrElseThrow(id);
		Postcode updatedPostcode = this.postcodeService.updatePostcode(postcode, data);
		return new ResponseEntity<Postcode>(updatedPostcode, HttpStatus.OK);
	}
	
	@PatchMapping("/current-code-{currentPostcode}")
	public ResponseEntity<Postcode> updatePostcodeByPostcode(@PathVariable int currentPostcode, @Valid @RequestBody PostcodeUpdateDTO data) {
		Postcode postcode = this.postcodeService.findPostcodeByPostcodeNumber(currentPostcode).orElseThrow(() -> {
			throw new NotFoundException("Could not find a postcode of code: " + currentPostcode);
		});
		Postcode updatedPostcode = this.postcodeService.updatePostcode(postcode, data);
		return new ResponseEntity<Postcode>(updatedPostcode, HttpStatus.OK);
	}
}
