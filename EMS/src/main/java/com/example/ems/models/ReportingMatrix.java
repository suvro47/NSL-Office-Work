package com.example.ems.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReportingMatrix {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rmid;
	private String reportingSupervisor;
	private String teamLeader;
	private String headOfDepartment;
	
	@OneToMany( targetEntity=Employee.class, mappedBy="reportringMatrix")
	@JsonIgnore
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public long getRmid() {
		return rmid;
	}
	public void setRmid(long rmid) {
		this.rmid = rmid;
	}
	public String getReportingSupervisor() {
		return reportingSupervisor;
	}
	public void setReportingSupervisor(String reportingSupervisor) {
		this.reportingSupervisor = reportingSupervisor;
	}
	public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	public String getHeadOfDepartment() {
		return headOfDepartment;
	}
	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}
	@Override
	public String toString() {
		return "ReportingMatrix [rmid=" + rmid + ", reportingSupervisor=" + reportingSupervisor + ", teamLeader="
				+ teamLeader + ", headOfDepartment=" + headOfDepartment + ", getRmid()=" + getRmid()
				+ ", getReportingSupervisor()=" + getReportingSupervisor() + ", getTeamLeader()=" + getTeamLeader()
				+ ", getHeadOfDepartment()=" + getHeadOfDepartment() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
