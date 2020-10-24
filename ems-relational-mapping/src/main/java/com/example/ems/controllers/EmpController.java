package com.example.ems.controllers;

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

import com.example.ems.dao.AddressRepository;
import com.example.ems.dao.EmployeeRepository;
import com.example.ems.models.Employee;

@RestController
public class EmpController {
	
	@Autowired
	EmployeeRepository erepo;
	
	@Autowired
	AddressRepository arepo;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> emp = erepo.findAll();
		if( emp.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return emp;
	}
	
	// Add Employee
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee( @RequestBody Employee emp ){
		erepo.save(emp);
		return ResponseEntity.ok().body("Employee created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Employee specified.");
	}
	
	// Get an employee with specified employee_id
	@GetMapping("/employee/{eid}")
	public Employee getUser(@PathVariable long eid){
		Optional<Employee> OpEmp =  erepo.findById(eid);
		if( ! OpEmp.isPresent() ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		}
		
		Employee emp = OpEmp.get();
		return emp;
	}
	
	
	@GetMapping("/employees/name/{name}")
	public List<Employee> getEmployeesBaseOnName( @PathVariable String name){
		List<Employee> emp = erepo.findEmployeeBasedOnName(name);
		if( emp.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return emp;
	}
	
	@GetMapping("/employees/sector/{sector_no}")
	public List<Employee> getEmployeeBaseOnSectorNo( @PathVariable int sector_no){
		List<Employee> emp = erepo.findEmployeeBasedOnSectorNo(sector_no);
		System.out.println(emp.size());
		if( emp.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return emp;
	}
	
	
	
}
