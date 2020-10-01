package com.example.demo.controllers;

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

import com.example.demo.models.Employee;
import com.example.demo.models.Role;
import com.example.demo.repository.EmpRepo;
import com.example.demo.repository.RoleRepo;

@RestController
public class RoleController {
	
	@Autowired
	RoleRepo trepo;
	
	@Autowired
	EmpRepo repo;
	
	@GetMapping("/roles")
	public List<Role> getRoles(){
		List<Role> role = trepo.findAll();
		if( role.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return role;
	}
	
	// Add role
	@PostMapping("/role")
	public ResponseEntity<Object> addRole( @RequestBody Role role ){
		trepo.save(role);
		return ResponseEntity.ok().body("Role created successfully."); 
		// else return ResponseEntity.unprocessableEntity().body("Failed to create the Role specified.");
	}
	
	// Add employee with specified role
	@PostMapping("/role/{rid}/employee/{eid}/add")
	public ResponseEntity<Object> addRoleEmployee( @PathVariable long rid, @PathVariable long eid ){
		
		boolean role_exist = trepo.existsById(rid);
		boolean emp_exist = repo.existsById(eid);
		
		if ( !role_exist || !emp_exist ) {  // check the roll and lid is valid or not 
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		}
		
		Optional<Role> OpRole = trepo.findById(rid);
		Optional<Employee> OpEmp = repo.findById(eid); 
		
		Role rol = OpRole.get();
		Employee employee = OpEmp.get();
		
		employee.setRole(rol);
		repo.save(employee);
		trepo.save(rol);
		
		
		return ResponseEntity.ok().body("Role updated successfully.");
	}
	
	
}




