package com.login.microservice.controller;

import java.util.List;
import java.util.Optional;

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

import com.login.microservice.model.User;
import com.login.microservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin("*")

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getList")
	@ApiOperation(value = "Getting the list of  user")
	public List<User> getUserList(){
		return service.getUserList();
	}
	@PostMapping("/addUser")
	@ApiOperation(value = "Register a user",
			notes = "Registering a user to the database")
	public String addUser(@RequestBody User user) {
		service.saveUser(user);
		return "Added user with id :: " + user.getUserId();		
	}
	
	@GetMapping("/getUser/{id}")
	@ApiOperation(value = "Get a user by user id")
	public User getUserById(@PathVariable(value= "id") String id) {
		
		Optional<User> oUser=  service.getUserById(id);
		User u = oUser.get();
		return u;	
	}
	@PutMapping("/updateUser/{id}")
	@ApiOperation(value = "Updating a user by user id")
	public User updateUser(@PathVariable String id , @RequestBody User user) {	
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Deleting a user by user id")

	public User deleteUser(@PathVariable String id) {
		return service.deleteUser(id);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	@ApiOperation(value = "Getting a user by user email")
	public User getUserByEmail(@PathVariable String email ) {
		return service.getUserByEmail(email);
	}
	

}
