package com.project.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.project.hotel.entity.CustomerBooking;

public interface CustomerBookingRepo extends CrudRepository<CustomerBooking, String> , JpaRepository<CustomerBooking, String>{

}
