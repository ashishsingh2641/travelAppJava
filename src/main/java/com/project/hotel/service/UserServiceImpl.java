package com.project.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.hotel.entity.User;
import com.project.hotel.exception.CustomException;
import com.project.hotel.repository.UserRepository;
import com.project.hotel.security.JwtTokenProvider;

@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepository;
	HttpHeaders responseHeaders = new HttpHeaders();

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public ResponseEntity<User> userRegister(User user) {

		if (null != user.getEmail() && null != user.getPhnNumber()
				&&	user.getEmail().trim().length() != 0
				&& user.getPhnNumber().toString().trim().length() != 0) {

			try {
				if(!isPhoneNumberOrEmailAlreadyExist(user))
				{
					user.setPassword(passwordEncoder.encode(user.getPassword()));
					userRepository.save(user);
					HttpHeaders responseHeaders = new HttpHeaders();
					responseHeaders.set("user","success reg");

					return ResponseEntity.status(HttpStatus.OK)
							.headers(responseHeaders)
							.body(user);
				}
				else {

					responseHeaders.set("user","EMAIL OR PHONE NUMBER ALREADY EXISTS ");
					return ResponseEntity.status(HttpStatus.FORBIDDEN)
							.headers(responseHeaders)
							.body(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
				.headers(responseHeaders)
				.body(user);
	}
	
	@Override
	public ResponseEntity<String> changePassword(String userId, String latestPassword) {
		
		Optional<User> returnUser = this.userRepository.findById(userId).map(user -> {
			user.setPassword(passwordEncoder.encode(latestPassword));
			return this.userRepository.save(user);
		});
		
		if(returnUser.isPresent())
			return ResponseEntity.status(HttpStatus.OK)
				.headers(responseHeaders)
				.body("Password Changed Successfully");
		
		
		return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
				.headers(responseHeaders)
				.body("Password Not Able to Change");
	}
	
	@Override
	public ResponseEntity<String> userLogin(User user) {
		
		try {
			System.out.println("User Name:- " +user.getEmail() );
			System.out.println("User Role :- " +userRepository.findByEmail(user.getEmail()).getRole());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			String jwtToken = jwtTokenProvider.createToken(user.getEmail(), userRepository.findByEmail(user.getEmail()).getRole());
			return ResponseEntity.status(HttpStatus.OK)
					.headers(responseHeaders)
					.body(jwtToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new CustomException("Invalid Username/Password Supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		/*
		 * User usernew=userRepository.findByphnNumber(user.getPhnNumber());
		 * if(null!=usernew) {
		 * if(user.getPhnNumber().equalsIgnoreCase(usernew.getPhnNumber()) &&
		 * user.getPassword().equalsIgnoreCase(usernew.getPassword())) { return
		 * ResponseEntity.status(HttpStatus.OK) .headers(responseHeaders)
		 * .body(usernew); } else { return ResponseEntity.status(HttpStatus.FORBIDDEN)
		 * .headers(responseHeaders) .body(usernew); } } return
		 * ResponseEntity.status(HttpStatus.FORBIDDEN) .headers(responseHeaders)
		 * .body(usernew);
		 */	
	}


	private boolean isPhoneNumberOrEmailAlreadyExist(User user) throws Exception
	{
		if(null!=userRepository.findByEmail(user.getEmail())) {
			System.out.println("USer Email Exists");
			return true;
		}
		else if(null!=userRepository.findByphnNumber(user.getPhnNumber())) {
			System.out.println("User Phone Exists");
			return true;
		}else{
			return false;
		}

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<String> getEmail(String emailId) {
		User user= userRepository.findByEmail(emailId);
		if(user != null)
			return ResponseEntity.status(HttpStatus.OK)
					.headers(responseHeaders)
					.body(user.getId());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Not Valid Email");
	}

	@Override
	public User retreiveUserByUserId(String userId) {
		return userRepository.findById(userId).orElse(new User());
	}

	@Override
	public ResponseEntity<User> updateRegister(User user) {
		User usr = userRepository.save(user);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("user","success update");
		return ResponseEntity.status(HttpStatus.OK)
				.headers(responseHeaders)
				.body(usr);
		
	}

	@Override
	public User retreiveUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
