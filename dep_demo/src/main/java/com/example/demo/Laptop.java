package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	public int lid;
	public String brand;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
	public void compile()
	{
		System.out.println("Compiling....");
	}
	
	
	
	

}
