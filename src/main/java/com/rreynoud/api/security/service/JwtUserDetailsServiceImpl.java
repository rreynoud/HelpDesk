package com.rreynoud.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rreynoud.api.security.jwt.JwtUserFactory;
import com.rreynoud.entity.User;
import com.rreynoud.service.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = this.userService.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(String.format("No User found with username '%s'.", email));
		}else {
			return JwtUserFactory.create(user);
		}
		
		
	}

}
