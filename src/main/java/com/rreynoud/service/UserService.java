package com.rreynoud.service;

import org.springframework.data.domain.Page;

import com.rreynoud.entity.User;

public interface UserService {

	User findByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(String id);
	
	void delete(User user);
	
	Page<User> findAll(int pag, int count);
}
