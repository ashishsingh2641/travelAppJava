package com.project.hotel.service;

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
	public String sendEmail(String emailId) { 
		System.out.println("Email Sending ....!!! ");
		User user = userRepo.findByEmail(emailId);
		if(user !=null)
			sendPlainTextMail(user);  
		return "Email Sent"; 
	}

	private void sendPlainTextMail(User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("pmadhav2498@gmail.com");
		mailMessage.setSubject("In Land Booking Confirmation .");
		mailMessage.setText("Dear Customer , "+ '\n'+'\n'
				+ "Welcome to IN LAND ... !!! "+ '\n' 
				+ "Your Booking has been confirmed, Our Respective Executive will be in touch with you for further discussion. " + '\n'+'\n'
				+ "Thanks & Regards, "+ '\n'
				+ "IN LAND Team");
		
				
				// + "User "+ user.getFirstName()+" "+user.getLastName()+" has booked the property ... !!! "
				// + "Mobile Number :- "+user.getPhnNumber()
				// + "Email Id :- "+user.getEmail());

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
