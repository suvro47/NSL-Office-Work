package com.example.ems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ems.dao.EmployeeRepository;
import com.example.ems.dao.SalaryBenefitRepository;
import com.example.ems.models.Employee;
import com.example.ems.models.SalaryBenefit;

@RestController
public class SalaryBenefitController {
	
	@Autowired
	SalaryBenefitRepository sbrepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	@GetMapping("/salary_benefits")
	public List<SalaryBenefit> getSalaryBenefitList(){
		List<SalaryBenefit> sb = sbrepo.findAll();
		if( sb.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return sb;
	}
	
	// Add Salary Benefit with specified Employee
	@PostMapping("/employee/{eid}/salary_benefit/add")
	public  ResponseEntity<Object> addSalaryBenefit( @PathVariable long eid, @RequestBody SalaryBenefit sb ){
		
		Optional<Employee> emp = erepo.findById(eid);
		
		if( ! emp.isPresent() ) return ResponseEntity.unprocessableEntity().body("Failed to add salary benefit with the Employee specified.");
		
		
		Employee employee = emp.get();
		employee.setSalaryBenefit(sb);
		sb.setEmployee(employee);
		sbrepo.save(sb);
        erepo.save(employee);	
		return ResponseEntity.ok().body("Salary Benefit added successfully.");
	}
	
	@PutMapping("/employee/{eid}/salary_benefit/{sbid}/update")
	public  ResponseEntity<Object> updateEmployeeSalaryBenefit( @PathVariable long eid, @PathVariable long sbid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<SalaryBenefit> OpSb = sbrepo.findById(sbid);
		
		if( ! OpEmp.isPresent() || !OpSb.isPresent() ) {
			return ResponseEntity.unprocessableEntity().body("Failed to add salary benefit with the Employee specified.");
		}
		
		SalaryBenefit sb = OpSb.get();  // retrieve instance from record
		Employee emp = OpEmp.get(); 
		
		emp.setSalaryBenefit(sb);
		sb.setEmployee(emp);
		erepo.save(emp);
		
		return ResponseEntity.ok().body("Employee salary benefit updated successfully.");
	}
	
	
	@DeleteMapping("/employee/{eid}/salary_benefit/delete")
	public ResponseEntity<Object> deleteEmployeeSalaryBenefit( @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid);
		if( ! OpEmp.isPresent() ) return ResponseEntity.unprocessableEntity().body("Failed to delete salary benefit with the Employee specified.");
		
		Employee emp = OpEmp.get();
		SalaryBenefit sb = emp.getSalaryBenefit();
		if( sb == null ) return ResponseEntity.unprocessableEntity().body("Failed to delete salary benefit with the Employee specified.");
		
		emp.setSalaryBenefit(null);
		erepo.save(emp);
		return ResponseEntity.ok().body("Employee salary benefit deleted successfully.");
	}
	
}
