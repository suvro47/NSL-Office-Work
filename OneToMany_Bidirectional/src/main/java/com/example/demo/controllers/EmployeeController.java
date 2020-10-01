package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmpRepo;
import com.example.demo.repository.RoleRepo;

@RestController
public class EmployeeController { 
	
	@Autowired
	EmpRepo repo;
	
	@Autowired
	RoleRepo trepo;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> emp = repo.findAll();
		if( emp.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return emp;
	}
	
	// Add employee
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee( @RequestBody Employee employee ){
		repo.save(employee);
		return ResponseEntity.ok().body("Employee created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Employee specified.");
	}

}
