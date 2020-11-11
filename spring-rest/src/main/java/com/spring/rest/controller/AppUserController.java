package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dto.AppUserDto;
import com.spring.rest.model.AppUser;
import com.spring.rest.service.AppUserService;

@RestController
public class AppUserController {
	
	@Autowired
	AppUserService userService;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to our website";
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<AppUser> addUser( @RequestBody AppUserDto userDto ) {
		
		AppUser user = userService.addUser(userDto);
		return ResponseEntity.ok().body(user); 
	}
	
	@GetMapping("/getUser/{mail}")
	public ResponseEntity<AppUser> getUser( @PathVariable( value = "mail" ) String email ){
		AppUser user = userService.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}
	
	

}
