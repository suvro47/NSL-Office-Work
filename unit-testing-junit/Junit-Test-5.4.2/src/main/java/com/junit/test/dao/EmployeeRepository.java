package com.junit.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.junit.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
