package com.example.demo.controller;

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

import com.example.demo.model.Laptop;
import com.example.demo.repository.LaptopRepo;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepo lrepo;

	
	@GetMapping("/laptops")
	public List<Laptop> getLaptops(){
		List<Laptop> laptops = lrepo.findAll();
		if( laptops.size() == 0 ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		return laptops;
	}
	
	@GetMapping("/laptop/{lid}")
	public Optional<Laptop> getStudent( @PathVariable("lid")  int lid) {
		
		boolean exit = lrepo.existsById(lid);
		if( !exit ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		return lrepo.findById(lid);
	}
	
	@PostMapping("/laptop")
	public Laptop addStudent( @RequestBody Laptop laptop) {
		lrepo.save(laptop);
		return laptop;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
