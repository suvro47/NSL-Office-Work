package com.spring.mokito.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mokito.entity.Student;
import com.spring.mokito.exceptions.ResourceNotFoundException;
import com.spring.mokito.payload.request.StudentDto;
import com.spring.mokito.repository.StudentRepository;
import com.spring.mokito.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		if( students.isEmpty() )
			throw new ResourceNotFoundException("No employee found");
	    return students;
	}

	@Override
	public Student getStudent(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long id, StudentDto dto) throws ResourceNotFoundException {
		// fetched from DB
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));
		
		// update student
		student.setName( dto.getName() );
		student.setPassword(dto.getPassword());
		// save into db
		studentRepository.save(student);
		
		return student;
	}

	@Override
	public List<Student> getAllStudentsWhoseNameStartsWithVowel() throws ResourceNotFoundException {
		
		List<Student> students = studentRepository.findAll();
		if( students.isEmpty() )
			throw new ResourceNotFoundException("No employee found");
		
		// Business Logic
		List<Student> res = new ArrayList<>();
		for( Student stu : students ) {
			String name = stu.getName();
			if( name.startsWith("A") || name.startsWith("E") || name.startsWith("I") || name.startsWith("O") || name.startsWith("U") ) 
				res.add(stu);
		}
		
	    return res;
	}
}
