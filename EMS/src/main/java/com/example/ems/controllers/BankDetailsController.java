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

import com.example.ems.dao.BankDetailsRepository;
import com.example.ems.dao.EmployeeRepository;
import com.example.ems.models.BankDetails;
import com.example.ems.models.Employee;

@RestController
public class BankDetailsController {
	
	@Autowired
	BankDetailsRepository bdrepo;

	@Autowired
	EmployeeRepository erepo;
	
	@GetMapping("/bank_details")
	public List<BankDetails> getAllBankDetails(){
		List<BankDetails> bds = bdrepo.findAll();
		if( bds.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return bds;
	}
	
	// Add Address info with specified Employee
	@PostMapping("/employee/{eid}/bank_details/add")
	public  ResponseEntity<Object> addBankDetails( @PathVariable long eid, @RequestBody BankDetails bankDetails ){
		
		Optional<Employee> emp = erepo.findById(eid);
		
		if( ! emp.isPresent() ) {
			return ResponseEntity.unprocessableEntity().body("Failed to add address with the Employee specified.");
		}
		
		Employee employee = emp.get();
		employee.setBankDetails(bankDetails);
	    bankDetails.setEmployee(employee);
		bdrepo.save(bankDetails);
        erepo.save(employee);	
		return ResponseEntity.ok().body("Employee Bank Details added successfully.");
	}
		
	// Update bank details for specified employee 
	@PutMapping("/employee/{eid}/bank_details/{bdid}/update")
	public  ResponseEntity<Object> updateEmployeeBankDetails( @PathVariable long eid, @PathVariable long bdid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<BankDetails> OpBd = bdrepo.findById(bdid);
		
		BankDetails bd = OpBd.get();  // retrieve instance from record
		Employee emp = OpEmp.get(); 
		
		emp.setBankDetails(bd);
		bd.setEmployee(emp);
		erepo.save(emp);
		
		return ResponseEntity.ok().body("Employee address updated successfully.");
	}
			
	// Delete Bank details with specified employee
	@DeleteMapping("/employee/{eid}/bank_details/delete")
	public ResponseEntity<Object> deleteBankDetails( @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid);
		
		if( ! OpEmp.isPresent() ) return ResponseEntity.unprocessableEntity().body("Failed to delete Bank Details with the Employee specified.");
		
		Employee emp = OpEmp.get();
		BankDetails bd = emp.getBankDetails();
		
		if( bd == null ) return ResponseEntity.unprocessableEntity().body("Failed to delete bank Details with the Employee specified.");

		emp.setBankDetails(null);
		erepo.save(emp);
		return ResponseEntity.ok().body("Employee Bank Details deleted successfully.");
	}
	
	
	
}
