package com.project.hotel.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.hotel.entity.User;

public interface UserService {
	public ResponseEntity<User> userRegister(@RequestBody User user);
	
	public ResponseEntity<String> userLogin( @RequestBody User user);
	
	public ResponseEntity<String> changePassword(String userId, String latestPassword);
	
	public List<User> getAllUsers();

	public ResponseEntity<String> getEmail(String emailId);
	
}
