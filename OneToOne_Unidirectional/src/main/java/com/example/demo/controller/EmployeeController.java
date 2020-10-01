package com.example.demo.controller;

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

import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String getIndex() {
		return "Project is running............";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		List<Employee> Emp = empRepo.findAll();
		if( Emp.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return empRepo.findAll();
	}
	
	// Add employee
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee( @RequestBody Employee employee ){
		empRepo.save(employee);
		return ResponseEntity.ok().body("Employee created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Employee specified.");
	}
	
	// Update Employee with address
	@PostMapping("/employee/{eid}/address/add")
	public  ResponseEntity<Object> addEmployeeAddress( @PathVariable long eid, @RequestBody Address address ){
		Optional<Employee> OpEmp = empRepo.findById(eid); // entity record
		if( !OpEmp.isPresent() ) {
			return ResponseEntity.unprocessableEntity().body("Failed to update the specified Employee");
		}
		
		Employee employee = OpEmp.get();
		employee.setAddress(address);
        empRepo.save(employee);		
		
		return ResponseEntity.ok().body("Successfully Updated Employee");
	}

}
