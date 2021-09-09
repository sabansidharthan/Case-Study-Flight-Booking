package com.user.microservice.controller;

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

import com.user.microservice.model.User;
import com.user.microservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getList")
	@ApiOperation(value = "Getting List of user")
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
	@ApiOperation(value = "Getting user by User ID")
	public User getUserById(@PathVariable(value= "id") String id) {
		
		Optional<User> oUser=  service.getUserById(id);
		User u = oUser.get();
		return u;	
	}
	@PutMapping("/updateUser/{id}")
	@ApiOperation(value = "Update user by User ID")
	public User updateUser(@PathVariable String id , @RequestBody User user) {	
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete user by User ID")

	public User deleteUser(@PathVariable String id) {
		return service.deleteUser(id);
	}
	
	
	

}
