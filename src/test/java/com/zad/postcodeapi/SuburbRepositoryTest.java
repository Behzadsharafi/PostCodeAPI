package com.zad.postcodeapi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.zad.postcodeapi.suburb.Suburb;
import com.zad.postcodeapi.suburb.SuburbRepository;

@DataJpaTest
public class SuburbRepositoryTest {

	@Autowired
	private SuburbRepository underTest;

	@Test
	void selectExistsTitile_TitleExists_ReturnTrue() {

		String name = "How to test Spring apps?";
		Suburb suburb = new Suburb(name, 10000, "2255");
		this.underTest.save(suburb);
		Boolean exists = this.underTest.selectExistsTitle(name);
		assertTrue(exists);

	}

	@Test
	void selectExistsTitle_TitleDoesntExist_ReturnsFALSE() {
		Boolean exists = this.underTest.selectExistsTitle("Some new name");
		assertFalse(exists);

	}

}
