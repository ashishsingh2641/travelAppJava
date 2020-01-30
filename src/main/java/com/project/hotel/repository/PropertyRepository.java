package com.project.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.hotel.entity.RegisterProperty;

public interface PropertyRepository extends CrudRepository<RegisterProperty, String> , JpaRepository<RegisterProperty, String>{

	List<RegisterProperty> findByCity(String city);

	@Query("SELECT DISTINCT rp.city FROM RegisterProperty rp")
	List<String> findDistinctCity();

	List<RegisterProperty> findByUserId(String userId);
	
	@Query("SELECT rp.ownerName as ownerName, rp.ownerMobileNo as ownerMobileNo, rp.ownerEmail as ownerEmail FROM RegisterProperty rp where rp.id = :propertyId")
	PropertySummary findByPropertyId(@Param("propertyId") String propertyId);

}
