package com.spring.rest.model;

public class AppUser {
	
	private String name;
	private String email;
	private String contactNo;
	
	public AppUser() {
	}
	
	public AppUser(String name, String email, String contactNo) {
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Override
	public String toString() {
		return "AppUser [name=" + name + ", email=" + email + ", contactNo=" + contactNo + "]";
	}
	
	
}
