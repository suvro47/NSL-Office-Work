package com.spring.file.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.file.model.AppUser;
import com.spring.file.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;

	
	@GetMapping("/users")
	public List<AppUser> getUsers(){
		List<AppUser> user = repo.findAll();
		if( user.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return user;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> addEmployee( @RequestBody AppUser user ){
		repo.save(user);
		return ResponseEntity.ok().body("User created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the User specified.");
	}
	
	@GetMapping("/user/{id}")
	public AppUser getUser(@PathVariable int id){
		Optional<AppUser> OpUser =  repo.findById(id);
		if( ! OpUser.isPresent() ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		}
		
		AppUser user = OpUser.get();
		return user;
	}
	
	
	
	
	
	
	
	
	

}
