package com.project.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.hotel.entity.User;
import com.project.hotel.repository.UserRepository;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserRepository userRepo;

	public EmailServiceImpl(JavaMailSender javaMailSender) { 
		this.javaMailSender = javaMailSender; 
	}

	@Override 
	public String sendEmail(String userId) { 
		System.out.println("Email Sending ....!!! ");
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent())
			sendPlainTextMail(userId, user.get());  
		return "Email Sent"; 
	}

	private void sendPlainTextMail(String userId, User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo("ashishsingh2641@gmail.com");
		mailMessage.setFrom("pmadhav2498@gmail.com");
		mailMessage.setSubject("This is A Test Mail");
		mailMessage.setText("Dear Admin ,"
				+ "User"+ user.getFirstName()+" "+user.getLastName()+" has booked the property"
				+ "Mobile Number :- "+user.getPhnNumber()
				+ "Email Id :- "+user.getEmail());

		/*
		 * eParams.getTo().toArray(new String[eParams.getTo().size()]);
		 * mailMessage.setTo(eParams.getTo().toArray(new
		 * String[eParams.getTo().size()])); mailMessage.setReplyTo(eParams.getFrom());
		 * mailMessage.setFrom(eParams.getFrom());
		 * mailMessage.setSubject(eParams.getSubject());
		 * mailMessage.setText(eParams.getMessage());
		 * 
		 * 
		 * 
		 * if (eParams.getCc().size() > 0) {
		 * mailMessage.setCc(eParams.getCc().toArray(new
		 * String[eParams.getCc().size()])); }
		 */


		javaMailSender.send(mailMessage); 
	}

}
