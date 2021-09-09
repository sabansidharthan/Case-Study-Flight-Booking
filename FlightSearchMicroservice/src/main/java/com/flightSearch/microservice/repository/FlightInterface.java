package com.flightSearch.microservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightSearch.microservice.model.Flight;
@Repository
public interface FlightInterface extends MongoRepository<Flight, Integer> {
	
	List<Flight> findBySourceAndDestinationAndDepartDate(String source,String destination,LocalDate date );
	List<Flight> findBySourceAndDestinationAndDepartDate(String source,String destination,String date );

	List<Flight> findBySourceAndDestination(String source,String destination);


}
