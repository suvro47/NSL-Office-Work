package com.example.ems.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aid;
	private long roadNo;
	private long sectorNo;
	
	@OneToOne(targetEntity=Employee.class)
	@JsonIgnore
	private Employee employee;

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public long getRoadNo() {
		return roadNo;
	}

	public void setRoadNo(long roadNo) {
		this.roadNo = roadNo;
	}

	public long getSectorNo() {
		return sectorNo;
	}

	public void setSectorNo(long sectorNo) {
		this.sectorNo = sectorNo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", roadNo=" + roadNo + ", sectorNo=" + sectorNo + "]";
	}
	
	
	
	

}
