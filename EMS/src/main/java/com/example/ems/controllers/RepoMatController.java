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
import com.example.ems.dao.ReportringMatrixRepository;
import com.example.ems.models.Employee;
import com.example.ems.models.ReportingMatrix;


@RestController
public class RepoMatController {
	
	@Autowired
	ReportringMatrixRepository rmrepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	// View all Reporting Matrix
	@GetMapping("/reportring_matrixes")
	public List<ReportingMatrix> getAllReportringMatrixes(){
		List<ReportingMatrix> repoMatrixes = rmrepo.findAll();
		if( repoMatrixes.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return repoMatrixes;
	}
	
	
	// Add ReportingMatrix
	@PostMapping("/reportring_matrix")
	public ResponseEntity<Object> addReportingMatrix( @RequestBody ReportingMatrix reportingMatrix ){
		rmrepo.save(reportingMatrix);
		return ResponseEntity.ok().body("Reporting Matrix created successfully."); 
	}
	
	
	// Update Employee with specified Reporting Matrix
	@PutMapping("/reportring_matrix/{rmid}/employee/{eid}/update")
	public ResponseEntity<Object> updateEmployee( @PathVariable long rmid, @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<ReportingMatrix> OpRepoMat = rmrepo.findById(rmid);
		
		ReportingMatrix rmat = OpRepoMat.get();  // retrieve object/instance from record
		Employee emp = OpEmp.get(); 
		
		emp.setReportringMatrix(rmat);
		erepo.save(emp);
		
		return ResponseEntity.ok().body("Employee Reporting Matrix updated successfully.");
	}
	
	// Delete Employee From Specified Reporting Matrix
	@DeleteMapping("/reportring_matrix/{rmid}/employee/{eid}/delete")
	public ResponseEntity<Object> deleteEmployee( @PathVariable long rmid, @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Employee emp = OpEmp.get();
		emp.setReportringMatrix(null); // employee_rmid field set as null 
		erepo.save(emp);
		return ResponseEntity.ok().body("Employee successfully removed from Reporting Matrix.");
		
	}
	
	
	

	

}



