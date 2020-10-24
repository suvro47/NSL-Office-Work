package com.example.ems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ems.dao.EmployeeRepository;
import com.example.ems.dao.SalaryRepository;
import com.example.ems.models.Employee;
import com.example.ems.models.Salary;

@RestController
public class SalaryController {
	
	@Autowired
	SalaryRepository srepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	@GetMapping("/salaries")
	public List<Salary> getAllSalary(){
		List<Salary> salary = srepo.findAll();
		if( salary.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return salary;
	}
	
	// Add Employee
	@PostMapping("/salary")
	public ResponseEntity<Object> addRole( @RequestBody Salary salary ){
		srepo.save(salary);
		return ResponseEntity.ok().body("Salary created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Salary specified.");
	}
	
	// Update employee with specified salary
	@PutMapping("/employee/{eid}/salary/{sid}/update")
	public ResponseEntity<Object> updateEmployee( @PathVariable long sid, @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<Salary> OpSalary = srepo.findById(sid);
		
		Salary salary = OpSalary.get();  // retrieve object/instance from record
		Employee emp = OpEmp.get(); 
		
		emp.setSalary(salary);
		erepo.save(emp);
		
		//salary.getEmployees().add(emp);	no need	
		//srepo.save(salary);
		
		return ResponseEntity.ok().body("Employee Salary updated successfully.");
	}
	
	
	
	
}
