package com.example.ems.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;
	private String name;
	private String email;
	
	@OneToOne(targetEntity=Address.class, cascade=CascadeType.ALL)
	@JsonIgnore
	private Address address;
	
	@ManyToOne(targetEntity=Salary.class)
	@JsonIgnore
	private Salary salary;
	
	@ManyToMany(targetEntity = Role.class, mappedBy="employees")  /// role_employees table will be created
	@JsonIgnore
	private List<Role> roles;
	
	@ManyToOne(targetEntity=ReportingMatrix.class)
	@JsonIgnore
	private ReportingMatrix reportringMatrix;
	
	@OneToOne(targetEntity=SalaryBenefit.class, cascade=CascadeType.ALL)
	@JsonIgnore
	private SalaryBenefit salaryBenefit;
	
	@OneToOne(targetEntity=BankDetails.class, cascade=CascadeType.ALL)
	@JsonIgnore
	private BankDetails bankDetails;
	
	@ManyToOne(targetEntity = AttendanceRoster.class)
	@JsonIgnore
	private AttendanceRoster attendenceRoaster;
	
	public AttendanceRoster getAttendenceRoaster() {
		return attendenceRoaster;
	}
	
	public void setAttendenceRoaster(AttendanceRoster attendenceRoaster) {
		this.attendenceRoaster = attendenceRoaster;
	}
	
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public Address getAddress() {
		return address;
	}
	public SalaryBenefit getSalaryBenefit() {
		return salaryBenefit;
	}
	public void setSalaryBenefit(SalaryBenefit salaryBenefit) {
		this.salaryBenefit = salaryBenefit;
	}
	public ReportingMatrix getReportringMatrix() {
		return reportringMatrix;
	}
	public void setReportringMatrix(ReportingMatrix reportringMatrix) {
		this.reportringMatrix = reportringMatrix;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}



