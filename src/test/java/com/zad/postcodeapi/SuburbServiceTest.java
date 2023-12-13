package com.zad.postcodeapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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

}
