package com.login.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.microservice.model.User;
import com.login.microservice.repository.UserInterface;

@Service
public class UserService {

	@Autowired
	private UserInterface userInterface;

	public void saveUser(User user) {
		userInterface.insert(user);
	}

	public List<User> getUserList() {
		return userInterface.findAll();
	}

	public Optional<User> getUserById(String id) {
		return userInterface.findById(id);
	}

	public User updateUser(String id, User u) {
		User user;
		user = userInterface.findById(id).orElse(null);
		user = u;
		user.setUserId(id);
		userInterface.save(user);
		return user;
	}

	public User deleteUser(String id) {
		User user;
		user = userInterface.findById(id).orElse(null);
		userInterface.delete(user);
		return user;
	}
	
	public User getUserByEmail(String Email) {
		return userInterface.getUserByEmail(Email);
	}

}
