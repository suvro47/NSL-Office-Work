package com.example.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ems.dao.AddressRepository;
import com.example.ems.models.Address;

@RestController
public class AddController {
	
	@Autowired
	AddressRepository arepo;
	
	@GetMapping("/addresses")
	public List<Address> getAddress(){
		List<Address> add = arepo.findAll();
		if( add.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return add;
	}
	
	
	
	

}
