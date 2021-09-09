package com.login.microservice.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.login.microservice.model.User;
@Repository
public interface UserInterface extends MongoRepository<User, String> {
	
	public User getUserByEmail(String email);


}
