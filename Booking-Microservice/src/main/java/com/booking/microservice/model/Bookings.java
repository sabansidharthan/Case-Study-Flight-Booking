package com.booking.microservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bookings")
public class Bookings {

	@Id
	private String bookingId;
	private String userEmail;
	private String firstName;
	private String lastName;
	private String passengerEmail;
	private String passengerPhone;
	private int passengerAge;
	private String gender;
	private Date bookingDate;
	private int flightId;
	
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bookings(String bookingId, String userEmail, String firstName, String lastName, String passengerEmail,
			String passengerPhone, int passengerAge, String gender, Date bookingDate, int flightId) {
		super();
		this.bookingId = bookingId;
		this.userEmail = userEmail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passengerEmail = passengerEmail;
		this.passengerPhone = passengerPhone;
		this.passengerAge = passengerAge;
		this.gender = gender;
		this.bookingDate = bookingDate;
		this.flightId = flightId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
