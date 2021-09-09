package com.user.microservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.microservice.model.User;
@Repository
public interface UserInterface extends MongoRepository<User, String> {


}
