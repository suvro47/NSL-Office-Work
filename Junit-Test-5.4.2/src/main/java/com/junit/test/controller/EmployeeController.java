package com.junit.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junit.test.dao.EmployeeRepository;
import com.junit.test.exception.ResourceNotFoundException;
import com.junit.test.model.Employee;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee( @RequestBody Employee employee ) {
		Employee savedEmployee = repo.save(employee);
		return ResponseEntity.ok().body(savedEmployee);
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<?>  getEmployee( @PathVariable int employeeId ) throws ResourceNotFoundException {
		Employee employee = repo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found") );
		
		return ResponseEntity.ok().body(employee);
	}
}
