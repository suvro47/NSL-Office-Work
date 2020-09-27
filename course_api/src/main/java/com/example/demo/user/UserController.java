package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return repo.findAll();	
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id){
		Optional<User> user =  repo.findById(id);
		boolean exit = repo.existsById(id);
		if( !exit ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		return user;
	}
	
	@PostMapping("/user")
	public User addUser( @RequestBody User user){  // requestbody is used to accept the json data
		
		List<User> users = repo.findByName(user.getName());
		
		if( users.size() > 0 ) {
			throw new ResponseStatusException( HttpStatus.CONFLICT, "Already Exist");
		}
		
		repo.save(user);
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
