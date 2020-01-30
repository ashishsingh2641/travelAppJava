package com.project.hotel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hotel.entity.CustomerBooking;
import com.project.hotel.service.EmailService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/notify")
public class EmailController {
	
	private EmailService emailService;
	
	public EmailController(EmailService emailService) {
		System.out.println("Email Controller Constructor");
		this.emailService = emailService;
	}
	
	@PostMapping("/sendEmail/{emailId}/{propertyId}")
	public String sendEmail(@PathVariable String emailId, @PathVariable String propertyId) {
		System.out.println("Email Post Call");
		return this.emailService.sendEmail(emailId,propertyId);
	}
	
	@PostMapping("/customerbooking/{emailId}")
	public CustomerBooking customerBooking(@PathVariable String emailId, 
			@RequestBody CustomerBooking custBook) {
		System.out.println("Customer Booking");
		return this.emailService.customerBooking(emailId,custBook);
	}
	
	@GetMapping("/getAllCustBookings")
	public List<CustomerBooking> getAllCustomerBookings() {
		return this.emailService.getAllCustomerBookings();
	}
	
	@PutMapping("/updateCustBooking/{bookingId}/{bookingStatus}")
	public ResponseEntity<Object> updateCustomerBooking(@PathVariable String bookingId, @PathVariable String bookingStatus, 
			@RequestBody CustomerBooking custBook) {
		return this.emailService.updateCustomerBooking(bookingId,bookingStatus);
	}

}
