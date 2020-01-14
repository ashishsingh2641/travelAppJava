package com.project.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.hotel.entity.CustomerBooking;
import com.project.hotel.entity.User;
import com.project.hotel.repository.CustomerBookingRepo;
import com.project.hotel.repository.UserRepository;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CustomerBookingRepo custBookRepo;

	public EmailServiceImpl(JavaMailSender javaMailSender) { 
		this.javaMailSender = javaMailSender; 
	}

	@Override 
	public String sendEmail(String emailId) { 
		System.out.println("Email Sending ....!!! ");
		
		User user = userRepo.findByEmail(emailId);
		
		if(user !=null) {
			sendPlainTextMail(user);
			sendMailToAdmin(user);
		}
			
		return "Email Sent"; 
	}

	private void sendPlainTextMail(User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("inlandhouse24@gmail.com");
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
	
	private void sendMailToAdmin(User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo("inlandhouse24@gmail.com");
		mailMessage.setFrom("inlandhouse24@gmail.com");
		mailMessage.setSubject("Customer "+user.getFirstName()+" "+user.getLastName()+" has booked the Property");
		mailMessage.setText("Dear Admin , "+ '\n'+'\n'
				+ "Please find the details ... !!! "+ '\n' 
				+ "Customer "+user.getFirstName()+" "+user.getLastName()+" booked the Property " + '\n'+'\n'
				+ "Mobile Number :- "+user.getPhnNumber()+ '\n'
				+ "Email Id :- "+user.getEmail()+ '\n'
				+ "Thanks & Regards, "+ '\n'
				+ "IN LAND Team");		
				
		javaMailSender.send(mailMessage); 
	}

	@Override
	public CustomerBooking customerBooking(String emailId, CustomerBooking custBook) {
		
		custBook.setCustomerId(userRepo.findByEmail(emailId));
		return custBookRepo.save(custBook);
	}

	@Override
	public List<CustomerBooking> getAllCustomerBookings() {
		return custBookRepo.findAll();
	}

}
