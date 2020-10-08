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

import com.example.ems.dao.AttendanceRosterRepository;
import com.example.ems.dao.EmployeeRepository;
import com.example.ems.models.AttendanceRoster;
import com.example.ems.models.Employee;

@RestController
public class AttendRosterController {
	
	@Autowired
	AttendanceRosterRepository arrepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	// View all Attendance Roster
	@GetMapping("/attendance_rosters")
	public List<AttendanceRoster> getAll(){
		List<AttendanceRoster> ar = arrepo.findAll();
		if( ar.size() == 0 ) throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Not Found" );
		return ar;
	}
	
	// Add Attendance Roster
	@PostMapping("/attendance_roster")
	public ResponseEntity<Object> addAttendanceRoster( @RequestBody AttendanceRoster ar ){
		arrepo.save(ar);
		return ResponseEntity.ok().body("Reporting Matrix created successfully."); 
	}
	
	
	// Update Employee with specified Attendance Roster
	@PutMapping("/attendance_roster/{arid}/employee/{eid}/update")
	public ResponseEntity<Object> updateEmployee( @PathVariable long arid, @PathVariable long eid ){
		
		Optional<Employee> OpEmp = erepo.findById(eid); 
		Optional<AttendanceRoster> OpAr = arrepo.findById(arid);
		
		AttendanceRoster ar = OpAr.get();  // retrieve object/instance from record
		Employee emp = OpEmp.get(); 
		
		emp.setAttendenceRoaster(ar);
		erepo.save(emp);
		
		return ResponseEntity.ok().body("Employee Reporting Matrix updated successfully.");
	}
	
	

}
