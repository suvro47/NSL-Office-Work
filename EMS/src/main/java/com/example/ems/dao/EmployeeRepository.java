package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
