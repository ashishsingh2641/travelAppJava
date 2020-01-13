package com.project.hotel.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/sendEmail/{emailId}")
	public String sendEmail(@PathVariable String emailId) {
		System.out.println("Email Post Call");
		return this.emailService.sendEmail(emailId);
	}
	
	@PostMapping("/customerbooking/{emailId}")
	public String customerBooking(@PathVariable String emailId) {
		System.out.println("Email Post Call");
		return this.emailService.customerBooking(emailId);
	}

}
