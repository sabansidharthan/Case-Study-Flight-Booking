package com.booking.microservice.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.booking.microservice.model.BookingDetails;
import com.booking.microservice.model.Bookings;
import com.booking.microservice.model.Flight;
import com.booking.microservice.service.Services;

@RestController
@RequestMapping("/bookings")
//@CrossOrigin("*")
public class Controller {

	@Autowired
	private Services services;
	
	@Autowired
	BookingDetails bookingDetails;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getbookings")
	public List<Bookings> getBookings() {
		return services.getBookings();
	}
	//get booking by bookingId
	@GetMapping("/booking/{id}")
	public Bookings getBookingById(@PathVariable(value = "id") String bookingId){
		Bookings booking = services.getBookings(bookingId);
		return booking;
	}	
	@GetMapping("/booking/mykey/{firstName}")
	public List <Bookings> getBookingByFirstname(@PathVariable(value = "firstName") String firstName){
	
		List <Bookings> booking = services.getBookingByFirstName(firstName);
		return booking;
	}
	
	@GetMapping("/bookingDet/{email}")
	public List<Bookings> getBookingByMail(@PathVariable(value = "email") String userEmail){
		List<Bookings> booking = services.getBookingDetailsById(userEmail);
		return booking;
	}
	
//booking details by email id
	@GetMapping("/bookingDetails/{id}")
	public List<Bookings> getBookingsById(@PathVariable(value = "id") String email){
		List<Bookings> bookings = services.getBookingDetailsById(email); 
		return bookings;
	}
 
 
 	
 	@PostMapping("/bookings")
	public String addBooking( @RequestBody Bookings booking) throws Exception{
		booking.setBookingDate(new Date());//find flight by id
		Flight flight = restTemplate.getForObject("http://localhost:8082/flight/findOne/" + booking.getFlightId(), Flight.class);
		System.out.println(flight+"-----------------------------------------------------------------");
		if(flight.getDepartDate().compareTo(LocalDate.now())<=0) {
			throw new Exception("Date must be greater than the current date");
		}
			services.addBooking(booking);
			return "booking added" + booking.getBookingId();
 	}
 	
	
	@PutMapping("/booking/{id}")
	public Bookings updateBookingById(@PathVariable(value = "id") String bookingId, 
			@RequestBody Bookings booking){
			
			Bookings updatedBooking = services.updateBooking(bookingId, booking);
			return updatedBooking;
	}
	
	
	@DeleteMapping("/booking/{id}")
    public Map<String, Boolean> deleteBooking(@PathVariable(value = "id") String bookingId){
        services.deleteBooking(bookingId);
        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
