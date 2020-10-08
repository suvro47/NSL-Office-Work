package com.example.ems.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bdid;
	private String bankName;
	private String branchName;
	private String accountNo;
	
	@OneToOne( targetEntity=Employee.class)
	@JsonIgnore
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getBdid() {
		return bdid;
	}
	public void setBdid(long bdid) {
		this.bdid = bdid;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	@Override
	public String toString() {
		return "BankDetails [bdid=" + bdid + ", bankName=" + bankName + ", branchName=" + branchName + ", accountNo="
				+ accountNo + "]";
	}
	
	
	

}
