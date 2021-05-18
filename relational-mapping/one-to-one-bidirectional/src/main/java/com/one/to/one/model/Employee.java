package com.one.to.one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long empId;
	
	@Column(name="employee_name")
	private String name;
	
	@JsonManagedReference             // parent entity 
	@OneToOne(mappedBy = "employee")  // mapped by employee column of laptop table, so laptop_id will not be created in employee table
	@JoinColumn(name="laptop_id")     // employee table will be the owner of the one-to-one relation
	private Laptop laptop;

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

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	
	
	
	

}
