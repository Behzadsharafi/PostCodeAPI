package com.zad.postcodeapi.suburb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zad.postcodeapi.exceptions.NotFoundException;
import com.zad.postcodeapi.postcode.Postcode;
import com.zad.postcodeapi.postcode.PostcodeService;
import com.zad.postcodeapi.postcode.PostcodeUtils;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/suburb")
public class SuburbController {
	@Autowired
	private SuburbService suburbService;
	@Autowired
	private PostcodeService postcodeServices;
	@Autowired
	private PostcodeUtils postcodeUtils;

	@PostMapping
	// Will create both post code and suburb rows
	public ResponseEntity<Suburb> createSuburbAndPostCode(@Valid @RequestBody SuburbCreateDTO data) {
		// If post code row doesn't exist, create one before creating suburb
		if (postcodeUtils.findOutDoesPostcodeExist(data.getPostcode()) == false) {
			this.postcodeServices.createPostcode(data.getPostcode());
		}
		Suburb newSuburb = this.suburbService.createSuburbAndPostCode(data);
		return new ResponseEntity<Suburb>(newSuburb, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Suburb>> findAllSuburbs() {
		List<Suburb> allSuburbs = this.suburbService.findAllSuburbs();
		return new ResponseEntity<List<Suburb>>(allSuburbs, HttpStatus.OK);
	}

	@GetMapping("/find-suburb-by-{postcode}")
	public ResponseEntity<List<Suburb>> findSuburbByPostcode(@PathVariable int postcode) {
		Postcode foundPostcode = postcodeUtils.findPostCodeByPostCodeOrElseThrow(postcode);
		List<Suburb> suburb = this.suburbService.findAllSuburbsByPostcode(foundPostcode.getPostcode());
		return new ResponseEntity<List<Suburb>>(suburb, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Suburb> findSuburbById(@PathVariable Long id) {
		return new ResponseEntity<Suburb>(findSuburbOrThrow(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Suburb> updateSuburbById(@PathVariable Long id, @Valid @RequestBody SuburbUpdateDTO data) {
		if (postcodeUtils.findOutDoesPostcodeExist(data.getPostcode()) == false) {
			postcodeServices.createPostcode(data.getPostcode());
		}
		Suburb suburb = findSuburbOrThrow(id);
		Suburb updatedSuburb = this.suburbService.updateSuburb(suburb, data);
		return new ResponseEntity<Suburb>(updatedSuburb, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Suburb> deleteSuburb(@PathVariable Long id) {
		Suburb suburb = findSuburbOrThrow(id);
		this.suburbService.deleteSuburb(suburb);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// Private Service Functions
	
	public Suburb findSuburbOrThrow(Long id) {
		return this.suburbService.findSuburbById(id).orElseThrow(() -> {
			throw new NotFoundException("Could not find suburb of ID: " + id);
		});
	}
}
