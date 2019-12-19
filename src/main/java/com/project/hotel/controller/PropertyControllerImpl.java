package com.project.hotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotel.entity.RegisterProperty;
import com.project.hotel.service.PropertyService;

@RestController
@RequestMapping("api/property")
public class PropertyControllerImpl implements PropertyController{
	private PropertyService service;
	
	public PropertyControllerImpl(PropertyService service){
		this.service=service;
	}

	@Override
	@PostMapping("/addProperty")
	public ResponseEntity<Object> addProperty(@RequestBody RegisterProperty prop) {
		return service.addProperty(prop);
	}
	
	@GetMapping({ "/getAllProperty" })
	public List<RegisterProperty> getAllProperty() {
		return (List<RegisterProperty>)this.service.getAllProperty();
	}

	@Override
	@GetMapping({ "/getAllProperty/{city}" })
	public List<RegisterProperty> getAllProperty(@PathVariable String city) {
		return (List<RegisterProperty>)this.service.getAllProperty(city);
	}

	@Override
	@GetMapping({ "/getAllCity" })
	public List<String> getAllCity() {
		return (List<String>)this.service.getAllCity();
	}

}
