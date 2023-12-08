package com.zad.postcodeapi.suburb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "suburbs")
public class Suburb {

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@Column
	private String name;

	@Getter
	@Setter
	@Column
	private Integer population;

	@Getter
	@Setter
	@Column
	private String postcode;

	public Suburb() {
	}

	public Suburb(String name, int population, String postcode) {
		this.name = name;
		this.population = population;
		this.postcode = postcode;

	}

}
