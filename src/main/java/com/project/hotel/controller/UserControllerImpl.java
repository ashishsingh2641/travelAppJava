package com.project.hotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotel.entity.User;
import com.project.hotel.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/user")
public class UserControllerImpl implements UserController{
	
	private UserService service;
	
	public UserControllerImpl(UserService service) {
		this.service=service;
	}

	@Override
	@PostMapping("/register")
	public ResponseEntity<User> userRegister(@RequestBody User user) {
		return service.userRegister(user);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody User user) {
		return service.userLogin(user);
	}
	
	@PutMapping("/changePassword/{userId}")
	public ResponseEntity<String> changePassword(@PathVariable String userId, @RequestParam String latestPassword) {
		return service.changePassword(userId,latestPassword);
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotel.entity.User;
import com.project.hotel.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/user")
public class UserControllerImpl implements UserController{
	
	private UserService service;
	
	public userControllerImpl(UserService service) {
		this.service=service;
	}

	@Override
	@PostMapping("/register")
	public ResponseEntity<User> userRegister(@RequestBody User user) {
		return service.userRegister(user);
	}

	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody User user) {
		return service.userLogin(user);
>>>>>>> branch 'master' of https://github.com/ashishsingh2641/travelAppJava.git
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

}
