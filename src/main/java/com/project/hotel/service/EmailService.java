package com.project.hotel.service;

import com.project.hotel.entity.CustomerBooking;

public interface EmailService {
	String sendEmail(String emailId);

	CustomerBooking customerBooking(String emailId, CustomerBooking custBook);
}
