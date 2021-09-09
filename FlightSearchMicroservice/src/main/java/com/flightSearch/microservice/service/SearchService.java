package com.flightSearch.microservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightSearch.microservice.model.Flight;
import com.flightSearch.microservice.repository.FlightInterface;
@Service
public class SearchService {
	
	@Autowired
	FlightInterface flightInterface;
	
	
	public void addFlight(Flight  flight) {
		flightInterface.insert(flight);		
	}
	//
	public List<Flight> getFlights() {
		return flightInterface.findAll();
	}
	//
	public Flight getFlightById(int id) {
		return flightInterface.findById(id).orElse(null);		
	}

	public Flight updateFlight(int id, Flight f) {
		Flight flight =  flightInterface.findById(id).orElse(null);
		flight = f;
		flight.setFlightNumber(id);
		flightInterface.save(flight);
		return flight;
	}
	
	public Flight deleteFlightById(int id){
		Flight flight =  flightInterface.findById(id)
				.orElseThrow(null);
		flightInterface.delete(flight);
		return flight;
	}

	public List<Flight> getFlightsBySourceAndDestinationAndDepartDate(String source,String destination,LocalDate date) {
		
		List<Flight> flights =  flightInterface.findBySourceAndDestinationAndDepartDate(source, destination, date);
		return flights;
	}
	
public List<Flight> getFlightsBySourceAndDestinationAndDepartDate(String source,String destination,String date) {
		
		List<Flight> flights =  flightInterface.findBySourceAndDestinationAndDepartDate(source, destination, date);
		return flights;
	}

public List<Flight> getFlightsBySourceAndDestination(String source,String destination) {
	
	List<Flight> flights =  flightInterface.findBySourceAndDestination(source, destination);
	return flights;
}

}
