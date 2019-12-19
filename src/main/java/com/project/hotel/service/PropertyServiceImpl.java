package com.project.hotel.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hotel.entity.RegisterProperty;
import com.project.hotel.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService{

	private PropertyRepository repository;
	
	public PropertyServiceImpl(PropertyRepository repository) {
		this.repository=repository;
	}

	@Override
	public ResponseEntity<Object> addProperty(RegisterProperty prop) {
		System.out.println("+++++++++++" + prop.getAddress1());
		repository.save(prop);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Object> updateProperty(String propertyId, RegisterProperty updatedProp) {
		System.out.println("Updating Property :- " + updatedProp.getId()+" Owner Name:- "+updatedProp.getOwnerName());
		boolean returnProp = false;
		
		returnProp = this.repository.findById(propertyId).map(property -> {
			updatedProp.setId(propertyId);
			return this.repository.save(updatedProp);
		}).isPresent();
		
		if(returnProp)
			return new ResponseEntity<Object>(HttpStatus.OK);
		else
			return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
	}
	
	public List<RegisterProperty> getAllProperty() {
		return (List<RegisterProperty>)this.repository.findAll();
	}

	@Override
	public List<RegisterProperty> getAllProperty(String city) {
		 return (List<RegisterProperty>)this.repository.findByCity(city);
	}

	@Override
	public List<String> getAllCity() {
		return (List<String>)this.repository.findDistinctCity();
	}
	
}
