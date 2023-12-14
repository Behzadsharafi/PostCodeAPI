package com.zad.postcodeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	}

	@Test
	void createSuburb_ValidSuburb_AddsSuburbToDB() {

		// Creating DTO
		SuburbCreateDTO dto = new SuburbCreateDTO("Suburb name", 1000, 2222);

		Suburb suburb = new Suburb("Suburb name", 1000, 2222);

		BDDMockito.given(mapper.map(dto, Suburb.class)).willReturn(suburb);

		this.underTest.createSuburbAndPostCode(dto);
		ArgumentCaptor<Suburb> suburbArgument = ArgumentCaptor.forClass(Suburb.class);

		Mockito.verify(suburbRepository).save(suburbArgument.capture());

		assertEquals(suburb, suburbArgument.getValue());
	}
}
