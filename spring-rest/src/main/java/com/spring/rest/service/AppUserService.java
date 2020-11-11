package com.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dto.AppUserDto;
import com.spring.rest.model.AppUser;
import com.spring.rest.repository.AppUserRepository;


@Service
public class AppUserService {

	@Autowired
	AppUserRepository userRepository;
	
	public AppUser addUser( AppUserDto userDto ) {

		/*
		 *AppUser user = new AppUser();
		 *user.setName(userDto.getName());
		 *user.setEmail(userDto.getEmail());
		 *user.setContactNo(userDto.getContactNo());

		 *instead of doing this you can perform this user creation operation in one line through constructor  
		 */

		AppUser user = new AppUser(userDto.getName(), userDto.getEmail(), userDto.getContactNo() );
		userRepository.save(user);
		return user; 
	}

	public AppUser findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
