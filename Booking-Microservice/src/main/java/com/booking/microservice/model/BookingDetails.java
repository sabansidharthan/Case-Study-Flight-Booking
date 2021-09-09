package com.booking.microservice.model;

import org.springframework.stereotype.Service;

@Service
public class BookingDetails {

	private Bookings booking;
	private Flight flight;
	
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDetails(Bookings booking, Flight flight) {
		super();
		this.booking = booking;
		this.flight = flight;
	}
	public Bookings getBooking() {
		return booking;
	}
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
