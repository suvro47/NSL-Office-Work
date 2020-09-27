package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OneToOne.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	

}
