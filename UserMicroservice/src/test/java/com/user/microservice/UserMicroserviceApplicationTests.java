package com.user.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.microservice.model.User;
import com.user.microservice.repository.UserInterface;
import com.user.microservice.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserMicroserviceApplicationTests {

	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserInterface repo;
		
	@Test
	public void getUserList() {
		when(repo.findAll()).thenReturn(Stream.of(new User("22","saban","saban@email.com","pass","12345654")).collect(Collectors.toList()));
		assertEquals(1, service.getUserList().size());
		
	}

}
