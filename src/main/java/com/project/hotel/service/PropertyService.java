package com.project.hotel.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.hotel.entity.RegisterProperty;

public interface PropertyService {
	public ResponseEntity<Object> addProperty(@PathVariable String userName, @RequestBody RegisterProperty prop);

	public List<RegisterProperty> getAllProperty(String city);

	public List<String> getAllCity();

	public List<RegisterProperty> getAllProperty();

	public ResponseEntity<Object> updateProperty(String propertyId, @Valid RegisterProperty updatedProp);

	public List<RegisterProperty> getPropDetailsByUser(String userName);

	public void deletePropertyById(String propertyId);

}
