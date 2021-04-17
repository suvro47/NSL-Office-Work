package com.login.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.system.model.User;
import com.login.system.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if( user == null ) throw new UsernameNotFoundException("Username Not Found");
		
		return new UserPrincipal(user);
	}

}
