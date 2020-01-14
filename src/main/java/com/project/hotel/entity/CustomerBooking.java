package com.project.hotel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CustomerBooking {
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private User customerId;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "property_id")
	private RegisterProperty propertyId;
	
	private String bookingStatus;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public RegisterProperty getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(RegisterProperty propertyId) {
		this.propertyId = propertyId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
}
