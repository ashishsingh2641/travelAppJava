package com.project.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
			//sendPlainTextMail(user);
			sendPlainTextMailNewBookingRequest(user);
			//sendPlainTextMailNewBookingConfirmation(user);
			//sendPlainTextMailNewBookingCancellation(user);
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
		mailMessage.setSubject("*** ALERT, New Booking Request**** | User "+user.getFirstName()+" "+user.getLastName()+" has Requested for Property");
		mailMessage.setText("Dear Admin , "+ '\n'+'\n'
				+ "New Property Booking Request is raised, below are the requested details. Kindly Start working on the Request, Contact to Property Owner & and Provide further updates to Customer. "+ '\n'+'\n' 
				+ "********* Customer Details **************" + '\n'
				+ "Property Requested By (Customer) : "+user.getFirstName()+" "+user.getLastName()+" "+ '\n'
				+ "Customer Contact No. :- "+user.getPhnNumber()+ '\n'
				+ "Customer Email :- "+user.getEmail()+ '\n'+'\n'
				+ "********* Property Owner Details ********" + '\n'
				+ "Property Owner Name : " +'\n'
				+ "Propery Owner Contact No. : "+ '\n'
				+ "Property Owner Email : " +'\n'+'\n'
				+ "######## More Property Details Visit Booking History in App ######"+'\n'+'\n'
				+ "------ Note : To Serve better Service, Notify Customer ASAP  ------" +'\n'+'\n'
				+ "Thanks & Regards, "+ '\n'
				+ "InLand Team");		
				
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

	@Override
	public ResponseEntity<Object> updateCustomerBooking(String bookingId, String bookingStatus) {
		
		boolean returnCustBooking = false;
		
		returnCustBooking = this.custBookRepo.findById(bookingId).map(custBooking -> {
			custBooking.setBookingStatus(bookingStatus);
			return this.custBookRepo.save(custBooking);
		}).isPresent();
		
		if(returnCustBooking)
			return new ResponseEntity<Object>(HttpStatus.OK);
		else
			return new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
	}
	//Sunil added
	private void sendPlainTextMailNewBookingRequest(User user) { 
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setFrom("inlandhouse24@gmail.com");
			mailMessage.setSubject("***** New Property Booking Request ******* #");
			mailMessage.setText("Dear User , "+ '\n'+'\n'
					+ "Thanks for Using InLand Service"+ '\n'+'\n' 
					+ "Your Booking process is in progress InLand Team is working on your request. \n You will be receiving email notification shortly from InLand Admin Team." + '\n'+'\n'
					+ "Thanks & Regards, "+ '\n'
					+ "InLand Team");
			javaMailSender.send(mailMessage); 
		}
	
	private void sendPlainTextMailNewBookingConfirmation(User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("inlandhouse24@gmail.com");
		mailMessage.setSubject("***** Booking Confirmation *******");
		mailMessage.setText("Dear User , "+ '\n'+'\n'
				+ "Congratulations!! "+ '\n' 
				+ "*********** Your Booking has been confirmed **********" + '\n'+'\n'
				+ "Thanks & Regards, "+ '\n'
				+ "InLand Team");
		javaMailSender.send(mailMessage); 
	}
	
	private void sendPlainTextMailNewBookingCancellation(User user) { 
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("inlandhouse24@gmail.com");
		mailMessage.setSubject("***** Booking Cancellation *******");
		mailMessage.setText("Dear User , "+ '\n'+'\n'
				+ "Unfortunately we couldn't book your requested property so cancelling your booking !! "+ '\n' 
				+ "Try next time we will server you better Service" + '\n'+'\n'
				+ "Thanks & Regards, "+ '\n'
				+ "InLand Team");
		javaMailSender.send(mailMessage); 
	}
}
