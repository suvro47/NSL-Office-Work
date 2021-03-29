package com.many.to.many.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long empId;
	
	@Column(name="employee_name")
	private String name;
	
	@ManyToMany(mappedBy = "employee")  // mapping is done by employee column of laptop table 
	private List<Laptop> laptop;  // this line is responsible for creating employee_laptop table 

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	

}
