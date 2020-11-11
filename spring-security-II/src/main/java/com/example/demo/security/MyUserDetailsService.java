package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Uzer;
import com.example.demo.UzerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
	@Autowired
	private UzerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Uzer uzer = repo.findByUsername(username);
		if( uzer == null ) throw new UsernameNotFoundException("Not Found");
		
		return new UserPrincpal(uzer);
	}
	
	

}
