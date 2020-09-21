package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Alien;
import com.example.demo.repository.AlienRepo;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController{
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping("/aliens")
	public List<Alien> getAliens(){
		return repo.findAll();	
	}
	
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid){
		return repo.findById(aid);	
	}
	
	@PostMapping("/alien")
	public Alien addAlien( @RequestBody Alien alien){  // requestbody is used to accept the json data
		repo.save(alien);
		return alien;
	}
	
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien( @PathVariable("aid") int aid ){ 
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		return "deleted";
	} 
	
	@PutMapping("/alien")
	public Alien updateAlien(Alien alien){
		repo.save(alien);
		return alien;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	

}
