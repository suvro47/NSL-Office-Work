package com.many.to.many.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="laptop_id")
	private Long lapId;
	
	@Column(name="laptop_model")
	private String model;
	
	@ManyToMany
	@JoinTable( name="laptop_employee", 
				joinColumns = @JoinColumn( name="laptop_id"),
				inverseJoinColumns = @JoinColumn( name="employee_id") 
	)
	private List<Employee> employee; // this line is responsible for creating laptop_employee table 

	public Long getLapId() {
		return lapId;
	}

	public void setLapId(Long lapId) {
		this.lapId = lapId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

}
