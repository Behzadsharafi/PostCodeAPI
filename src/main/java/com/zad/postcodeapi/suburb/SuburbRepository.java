package com.zad.postcodeapi.suburb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuburbRepository extends JpaRepository<Suburb, Long> {
	
	@Query("" +

            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Suburb s " +
            "WHERE s.name = ?1"
    )

 Boolean selectExistsTitle(String name);

}
