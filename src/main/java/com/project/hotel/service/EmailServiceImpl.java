package com.project.hotel.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public String sendEmail() {
		return "Test Mail";
	}

	/*
	 * private JavaMailSender javaMailSender;
	 * 
	 * public EmailServiceImpl(JavaMailSender javaMailSender) { this.javaMailSender
	 * = javaMailSender; }
	 * 
	 * @Override public String sendEmail() { System.out.println("IN Email");
	 * sendPlainTextMail(); //javaMailSender.send(mimeMessagePreparator); return
	 * "sent"; }
	 * 
	 * private void sendPlainTextMail() { SimpleMailMessage mailMessage = new
	 * SimpleMailMessage(); mailMessage.setTo("pmadhav2498@gmail.com");
	 * mailMessage.setFrom("pmadhav2498@gmail.com");
	 * mailMessage.setSubject("This is A Test Mail");
	 * 
	 * mailMessage.setText("Text Datas....");
	 * 
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
	 * 
	 * 
	 * javaMailSender.send(mailMessage); }
	 */

}
