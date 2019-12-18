package com.project.hotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.hotel.entity.RegisterProperty;

public interface PropertyController {
	public ResponseEntity<Object> addProperty(@RequestBody RegisterProperty prop);
	
	List<RegisterProperty> getAllProperty(@PathVariable final String city);
    
    List<String> getAllCity();
}
