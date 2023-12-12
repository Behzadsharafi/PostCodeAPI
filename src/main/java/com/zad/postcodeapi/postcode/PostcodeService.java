package com.zad.postcodeapi.postcode;



import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class PostcodeService {
	@Autowired
	PostcodeRepository postcodeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public Postcode createPostcode(PostcodeCreateDTO data) {
		Postcode newPostcode = new Postcode();
		newPostcode.setPostcode(data.getPostcode());
		return this.postcodeRepository.save(newPostcode);
	}
	
	// An overload to accept post code integer
	public Postcode createPostcode(int postcodeNumber) {
	    Postcode newPostCode = new Postcode();
	    newPostCode.setPostcode(postcodeNumber);
	    return this.postcodeRepository.save(newPostCode);
	}
	
	public List<Postcode> findAllPostcodes() {
		return this.postcodeRepository.findAll();
	}
	
	public Optional<Postcode> findPostcodeById(Long id) {
		return this.postcodeRepository.findById(id);
	}
	
	public Optional<Postcode> findPostcodeByPostcodeNumber(int postcode) {
		return this.postcodeRepository.findByPostcode(postcode);
	}
	
	public Postcode updatePostcode(Postcode postcode, PostcodeUpdateDTO data) {
		mapper.map(data, postcode);
		return this.postcodeRepository.save(postcode);
	}
	
	// Omit delete due to post code table coupled with suburb table as foreign key
}
