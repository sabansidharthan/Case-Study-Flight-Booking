package com.apigateway.service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apigateway.model.UserProfile;
import com.apigateway.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserProfile> user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Not found"); 
		}
		 List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.get().getEmail()));
		 System.out.println(user.get().getEmail());
		 System.out.println(user.get().getUserName());
		 System.out.println(user.get().getPassword());
		
		return new User(user.get().getEmail(), user.get().getPassword(),authorities);
	}

}
