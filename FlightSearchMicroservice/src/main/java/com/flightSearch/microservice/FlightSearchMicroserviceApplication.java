package com.flightSearch.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightSearchMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchMicroserviceApplication.class, args);
	}

}
