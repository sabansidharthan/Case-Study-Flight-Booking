package com.flightSearch.microservice.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Bookings {

	@Id
	private String bookingId;
	private String userEmail;
	private String passengerName;
	private String passengerEmail;
	private String passengerPhone;
	private int passengerAge;
	private Date bookingDate;
	private int flightId;
	
	public Bookings(String bookingId, String userEmail, String passengerName, String passengerEmail,
			String passengerPhone, int passengerAge, Date bookingDate, int flightId) {
		super();
		this.bookingId = bookingId;
		this.userEmail = userEmail;
		this.passengerName = passengerName;
		this.passengerEmail = passengerEmail;
		this.passengerPhone = passengerPhone;
		this.passengerAge = passengerAge;
		this.bookingDate = bookingDate;
		this.flightId = flightId;
	}
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	
	
	

	
	
	
}
