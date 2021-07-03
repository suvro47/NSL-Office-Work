package com.spring.mokito.service;

import java.util.List;

import com.spring.mokito.entity.Student;
import com.spring.mokito.exceptions.ResourceNotFoundException;
import com.spring.mokito.payload.request.StudentDto;

public interface StudentService {
	
	List<Student> getAllStudents() throws ResourceNotFoundException;
	
	Student getStudent(Long id) throws ResourceNotFoundException;

	void addStudent(Student student);

	Student updateStudent(Long id, StudentDto dto ) throws ResourceNotFoundException;

	List<Student> getAllStudentsWhoseNameStartsWithVowel() throws ResourceNotFoundException;
}
