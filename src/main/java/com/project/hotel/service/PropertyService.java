package com.project.hotel.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.hotel.entity.RegisterProperty;

public interface PropertyService {
	public ResponseEntity<Object> addProperty(@RequestBody RegisterProperty prop);

	public List<RegisterProperty> getAllProperty(String city);

	public List<String> getAllCity();
}
