package com.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.hotel.entity.RegisterProperty;

public interface PropertyRepository extends JpaRepository<RegisterProperty, String>{

	List<RegisterProperty> findByCity(String city);

	@Query("SELECT DISTINCT rp.city FROM RegisterProperty rp")
	List<String> findDistinctCity();

}
