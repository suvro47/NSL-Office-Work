package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo srepo;
	
	@GetMapping("/")
	public String getIndex() {
		return "Project is running.......";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = srepo.findAll();
		if( students.size() == 0 ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		return students;
	}
	
	@GetMapping("/student/{roll}")
	public Optional<Student> getStudent( @PathVariable("roll")  int roll) {
		
		boolean exit = srepo.existsById(roll);
		if( !exit ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		return srepo.findById(roll);
	}
	
	@PostMapping("/student")
	public Student addStudent( @RequestBody Student student) {
		srepo.save(student);
		return student;
	}
	
	@DeleteMapping("/student/{roll}")
	public String deleteStudent( @PathVariable("roll") int roll ) {
		boolean exit = srepo.existsById(roll);
		if( !exit ) {
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "User not found" );
		}
		srepo.deleteById(roll);
		return "delete successfull";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
