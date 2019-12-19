package com.project.hotel.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	
	private JavaMailSender javaMailSender;
	
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public String sendEmail(String emailMessage) {
		return emailMessage;
		
		//javaMailSender.send(mimeMessagePreparator);
	}

}
