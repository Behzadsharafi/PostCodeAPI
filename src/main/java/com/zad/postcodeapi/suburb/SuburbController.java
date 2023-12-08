package com.zad.postcodeapi.suburb;

import java.util.List;
import java.util.Optional;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {

	@Autowired
	private SuburbService suburbService;

	@GetMapping
	public ResponseEntity<List<Suburb>> getAll() {
		List<Suburb> allSuburbs = this.suburbService.getAll();
		return new ResponseEntity<>(allSuburbs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Suburb> createSuburb(@Valid @RequestBody SuburbCreateDTO data) {
		Suburb newSuburb = this.suburbService.createSuburb(data);

		return new ResponseEntity<Suburb>(newSuburb, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Suburb> getById(@PathVariable Long id) {
		Optional<Suburb> found = suburbService.getById(id);
		if (found.isPresent()) {
			return new ResponseEntity<Suburb>(found.get(), HttpStatus.OK);
		}
		throw new NotFoundException(String.format("Suburb with id: %d does not exist.", id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Suburb> deleteById(@PathVariable Long id) {
		boolean deleted = this.suburbService.deleteById(id);
		if (deleted == true) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

		throw new NotFoundException(String.format("Suburb with id: %d does not exist, could not delete.", id));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Suburb> updateById(@PathVariable Long id, @Valid @RequestBody SuburbUpdateDTO data) {
		Optional<Suburb> updated = this.suburbService.updateById(id, data);

		if (updated.isPresent()) {
			return new ResponseEntity<Suburb>(updated.get(), HttpStatus.OK);
		}

		throw new NotFoundException(String.format("Suburb with id: %d does not exist, could not update", id));

	}

}
