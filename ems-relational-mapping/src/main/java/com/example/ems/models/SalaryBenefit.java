package com.example.ems.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SalaryBenefit {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long sbid;
	private long joiningSalary;
	private long lastIncrementAmount;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;
	private long presentSalary;
	private boolean promotionStatus;
	
	@OneToOne(targetEntity=Employee.class)
	@JsonIgnore
	private Employee employee;
	
	public long getSbid() {
		return sbid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setSbid(long sbid) {
		this.sbid = sbid;
	}
	public long getJoiningSalary() {
		return joiningSalary;
	}
	public void setJoiningSalary(long joiningSalary) {
		this.joiningSalary = joiningSalary;
	}
	public long getLastIncrementAmount() {
		return lastIncrementAmount;
	}
	public void setLastIncrementAmount(long lastIncrementAmount) {
		this.lastIncrementAmount = lastIncrementAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getPresentSalary() {
		return presentSalary;
	}
	public void setPresentSalary(long presentSalary) {
		this.presentSalary = presentSalary;
	}
	public boolean isPromotionStatus() {
		return promotionStatus;
	}
	public void setPromotionStatus(boolean promotionStatus) {
		this.promotionStatus = promotionStatus;
	}
	@Override
	public String toString() {
		return "SalaryBenefit [sbid=" + sbid + ", joiningSalary=" + joiningSalary + ", lastIncrementAmount="
				+ lastIncrementAmount + ", date=" + date + ", presentSalary=" + presentSalary + ", promotionStatus="
				+ promotionStatus + "]";
	}
	

}
