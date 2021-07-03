package com.spring.mokito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mokito.entity.Student;
import com.spring.mokito.exceptions.ResourceNotFoundException;
import com.spring.mokito.payload.request.StudentDto;
import com.spring.mokito.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService StudentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudent() throws ResourceNotFoundException {
		return StudentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent( @PathVariable("id") Long id ) throws ResourceNotFoundException {
		return StudentService.getStudent(id);
	}
	
	@PostMapping("/student")
	public void addStudent( @RequestBody Student student ) {
		StudentService.addStudent(student);
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent( @PathVariable("id") Long id , @RequestBody StudentDto dto ) throws ResourceNotFoundException {
		return StudentService.updateStudent(id, dto);
	}
	
	@GetMapping("/students/name_starts_with_vowel")
	public List<Student> getAllStudentWhoseNameStartsWithVowel() throws ResourceNotFoundException {
		return StudentService.getAllStudentsWhoseNameStartsWithVowel();
	}
	
}
