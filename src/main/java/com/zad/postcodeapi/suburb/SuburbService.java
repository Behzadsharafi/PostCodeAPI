package com.zad.postcodeapi.suburb;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SuburbService {

	@Autowired
	private SuburbRepository suburbRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<Suburb> getAll() {
		return this.suburbRepository.findAll();
	}

	public Suburb createSuburb(SuburbCreateDTO data) {

		Suburb newSuburb= modelMapper.map(data, Suburb.class);
		
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

	public Optional<Suburb> updateById(Long id, SuburbUpdateDTO data) {
		Optional<Suburb> foundSuburb = this.getById(id);

		if (foundSuburb.isPresent()) {
			Suburb toUpdate = foundSuburb.get();

			modelMapper.map(data, toUpdate);
			Suburb updatedSuburb = this.suburbRepository.save(toUpdate);

			// We turn this to an optional because the data type that we are returning is an
			// optional. This is an optional that always exists!
			return Optional.of(updatedSuburb);

		}

		return foundSuburb;
	}

}
