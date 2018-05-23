package com.rreynoud.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rreynoud.entity.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
	
}
