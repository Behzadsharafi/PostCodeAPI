package com.zad.postcodeapi.suburb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SuburbService {

	@Autowired
	private SuburbRepository suburbRepository;

	public List<Suburb> getAll() {
		return this.suburbRepository.findAll();
	}

	public Suburb createSuburb(SuburbCreateDTO data) {

		String name = data.getName().trim();
		int population = data.getPopulation();
		String postcode = data.getPostcode().trim();

		Suburb newSuburb = new Suburb(name, population, postcode);
		Suburb created = this.suburbRepository.save(newSuburb);
		return created;
	}

	public Optional<Suburb> getById(Long id) {
		Optional<Suburb> foundSuburb = suburbRepository.findById(id);
		return foundSuburb;
	}

	public boolean deleteById(Long id) {
		Optional<Suburb> foundSuburb = this.getById(id);
		if (foundSuburb.isPresent()) {
			this.suburbRepository.delete(foundSuburb.get());
			return true;
		}
		return false;
	}

}
