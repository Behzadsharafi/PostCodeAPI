package com.zad.postcodeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.zad.postcodeapi.suburb.Suburb;
import com.zad.postcodeapi.suburb.SuburbCreateDTO;
import com.zad.postcodeapi.suburb.SuburbRepository;
import com.zad.postcodeapi.suburb.SuburbService;

@ExtendWith(MockitoExtension.class)
public class SuburbServiceTest {

	@Mock
	private SuburbRepository suburbRepository;

	@Mock
	private ModelMapper mapper;

	@InjectMocks
	private SuburbService underTest;

	@Test
	void getAll_ReturnsAllData() {
		underTest.getAll();
		Mockito.verify(suburbRepository).findAll();
		// We are verifying that suburbRepository was called with findAll method.
	}

	@Test
	void createSuburb_ValidSuburb_AddSuburbToDB() {

		// Creating DTO
		SuburbCreateDTO dto = new SuburbCreateDTO("Suburb Name", 6000, "Suburb Postcode");

		Suburb suburb = new Suburb("Suburb Name", 6000, "Suburb Postcode");

		// Now we need to mock what mapper does.
		// We are telling the fake mapper what to return if we gave it dto and Suburb.
		BDDMockito.given(mapper.map(dto, Suburb.class)).willReturn(suburb);

		this.underTest.createSuburb(dto);
		// This should trigger the mapper.
		// We just want to check that the repository was called with the right argument.

		ArgumentCaptor<Suburb> suburbArgument = ArgumentCaptor.forClass(Suburb.class);
		// We are capturing the argument that the repository was called with.

		// We need the capture() method to actually get access to that argument.

		// We are checking that the save method was called.
		// We are also capturing the argument that it was called with.
		Mockito.verify(suburbRepository).save(suburbArgument.capture());

		// We are checking if what save was called with is the same as our suburb.
		assertEquals(suburb, suburbArgument.getValue());

		// We gave it a dto but it should be called with a suburb not a dto.
	}

	@Test
	void deletById_ExistingId_ReturnsTrue() {

		Long id = 123l;
		Suburb suburb = new Suburb("Suburb Name", 6000, "Suburb Postcode");

		// Here we are saying that the suburb exists.
		BDDMockito.given(suburbRepository.findById(id)).willReturn(Optional.of(suburb));

		Boolean deleted = this.underTest.deleteById(id);

		// capture the argument from the repository method
		ArgumentCaptor<Suburb> suburbArg = ArgumentCaptor.forClass(Suburb.class);
		// check if the right repository method was called, if yes we know it worked
		// because we didn't write that code.
		Mockito.verify(suburbRepository).delete(suburbArg.capture());
		// check that deleted == true
		assertTrue(deleted);
		// check that the save method was called with the right stuff.
		assertEquals(suburb, suburbArg.getValue());
	}

}
