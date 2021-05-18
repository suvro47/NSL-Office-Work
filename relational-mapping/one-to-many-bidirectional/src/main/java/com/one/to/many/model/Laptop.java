package com.one.to.many.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="laptop_id")
	private Long lapId;
	
	@Column(name="laptop_model")
	private String model;
	

    @JsonIgnore  // ignoring the circular reference
	@ManyToOne
	@JoinColumn( name="employee_id" )
	private Employee employee;

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
	
	

}
