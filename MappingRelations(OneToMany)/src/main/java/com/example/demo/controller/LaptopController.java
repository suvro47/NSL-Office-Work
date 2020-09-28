package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Laptop;
import com.example.demo.repository.LaptopRepo;

@RestController
public class LaptopController {
	
	@Autowired
	LaptopRepo lrepo;
	
	@PostMapping("/laptop/")
	public String addLaptop(  @RequestBody Laptop laptop)
	{
		lrepo.save(laptop);
		return "laptop added";
	}
	
	@GetMapping("/laptops")
	public List<Laptop> getLaptops(){
		return lrepo.findAll();
	}
	
	
	
	
	
	
}
