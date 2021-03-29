package com.one.to.many.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long empId;
	
	@Column(name="employee_name")
	private String name;
	
	@OneToMany( mappedBy = "employee" )  // mapped by employee column of laptop table, so employee_laptop table will not be created
	private List<Laptop> laptop;

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
