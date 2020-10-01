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

import com.example.ems.dao.EmployeeRepository;
import com.example.ems.dao.RoleRepository;
import com.example.ems.models.Employee;
import com.example.ems.models.Role;

@RestController
public class RoleController {
	
	@Autowired
	RoleRepository rrepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	@GetMapping("/roles")
	public List<Role> getRoles(){
		List<Role> roles = rrepo.findAll();
		if( roles.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return roles;
	}
	
	// Add Role
	@PostMapping("/role")
	public ResponseEntity<Object> addRole( @RequestBody Role role ){
		rrepo.save(role);
		return ResponseEntity.ok().body("Role created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Employee specified.");
	}
	
	// Add Role with specified employee
	@PostMapping("/employee/{eid}/role/{rid}/add")
	public  ResponseEntity<Object> updateEmployeeAddres( @PathVariable long rid, @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<Role> OpRole = rrepo.findById(rid);
		
		Role role = OpRole.get();  // retrieve instance from record
		Employee emp = OpEmp.get(); 
		
		emp.getRoles().add(role);
		role.getEmployees().add(emp);
		erepo.save(emp);
		// rrepo.save(role); no need
		
		return ResponseEntity.ok().body("Employee Role updated successfully.");
	}
	
	

}
