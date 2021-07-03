package com.spring.mokito.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.mokito.entity.Student;
import com.spring.mokito.exceptions.ResourceNotFoundException;
import com.spring.mokito.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class StudentServiceImplTest {
	
	@InjectMocks  // class under test
	StudentServiceImpl studentService; 
	
	@Mock  // contains dependent method
	StudentRepository studentRepositoryMock;

	@Test
	void testGetStudentsWhoseNameStartsWithVowel() throws ResourceNotFoundException {
				
		List<Student> students = new ArrayList<Student> (
				List.of(new Student(1L, "Avro", "pass01" ),
						new Student(2L, "Svro", "pass02" ),
						new Student(3L, "Ovro", "pass03" ),
						new Student(4L, "Utso", "pass04" ))
				);
		
		when(studentRepositoryMock.findAll()).thenReturn(students);
		
		List<Student> filteredStudents = studentService.getAllStudentsWhoseNameStartsWithVowel();
		
		assertEquals(3, filteredStudents.size());
	}
	
	
	

}
