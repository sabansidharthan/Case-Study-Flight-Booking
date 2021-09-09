package com.booking.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.microservice.model.Bookings;
import com.booking.microservice.repository.BookingInterface;

@Service
public class Services {
	
	@Autowired
	BookingInterface bookingInterface;
	
	public void addBooking(Bookings booking) {
		bookingInterface.save(booking);
	}

	
	public List<Bookings> getBookings() {
		return bookingInterface.findAll();
	}

	public Bookings getBookings(String id){
		return bookingInterface.findById(id).orElse(null);
	}
	
	public List<Bookings> getBookingDetailsById(String id){
		return bookingInterface.findAllByUserEmail(id);
	}
	
	public List<Bookings> getBookingByFirstName(String firstName){
		return bookingInterface.findAllByFirstName(firstName);
	}

	public Bookings updateBooking(String id, Bookings b) {
		Bookings booking =  bookingInterface.findById(id).orElse(null);
		booking = b;
		booking.setBookingId(id);
		bookingInterface.save(booking);
		return booking;
	}

	public Bookings deleteBooking(String id) {
		Bookings booking =  bookingInterface.findById(id).orElse(null);
		bookingInterface.delete(booking);
		return booking;
	}

}
