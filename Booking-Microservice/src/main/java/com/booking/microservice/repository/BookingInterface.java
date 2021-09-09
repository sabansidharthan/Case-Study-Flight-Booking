package com.booking.microservice.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booking.microservice.model.Bookings;



@Repository
public interface BookingInterface extends MongoRepository<Bookings, String>{
	
	List<Bookings> findAllByUserEmail(String email);
	List<Bookings> findAllByFirstName(String firstName);
}
