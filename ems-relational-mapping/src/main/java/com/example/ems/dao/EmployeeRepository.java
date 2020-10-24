package com.example.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ems.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	// Return employee based on name
	@Query(value=" SELECT * FROM employee WHERE name = ?1 ", nativeQuery=true)
	List<Employee> findEmployeeBasedOnName(String name);
	
	// Return employee based on sector no
	@Query(value="SELECT emp.* FROM employee emp INNER JOIN address add ON emp.eid = add.employee_eid WHERE add.sector_no = ?1 ", nativeQuery=true)
	List<Employee> findEmployeeBasedOnSectorNo( int sec_no );
	
}
