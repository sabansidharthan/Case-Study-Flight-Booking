package com.user.microservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.user"))
				.build().apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return  new ApiInfo(
				"User Service",
				"User Management for Flight Booking",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Saban S", "http://flightbooking.com","saban@email.com"),
				"Api License",
				"http://flightbooking.com",
				Collections.emptyList());

}
	
	
}
