package com.example.ems.models;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AttendanceRoster {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private long arid;
	@JsonFormat(pattern = "hh:mm:ss")
	private Time officeStartTime;
	@JsonFormat(pattern = "hh:mm:ss")
	private Time officeEndTime;
	private long weekends;
	
	@OneToMany( targetEntity = Employee.class, mappedBy="attendenceRoaster")
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public long getArid() {
		return arid;
	}
	public void setArid(long arid) {
		this.arid = arid;
	}
	public Time getOfficeStartTime() {
		return officeStartTime;
	}
	public void setOfficeStartTime(Time officeStartTime) {
		this.officeStartTime = officeStartTime;
	}
	public Time getOfficeEndTime() {
		return officeEndTime;
	}
	public void setOfficeEndTime(Time officeEndTime) {
		this.officeEndTime = officeEndTime;
	}
	public long getWeekends() {
		return weekends;
	}
	public void setWeekends(long weekends) {
		this.weekends = weekends;
	}
	@Override
	public String toString() {
		return "AttendanceRoster [arid=" + arid + ", officeStartTime=" + officeStartTime + ", officeEndTime="
				+ officeEndTime + ", weekends=" + weekends + "]";
	}
	
	
	
}
