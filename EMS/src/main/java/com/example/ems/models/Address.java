package com.example.ems.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aid;
	private long road_no;
	private long sector_no;
	
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public long getRoad_no() {
		return road_no;
	}
	public void setRoad_no(long road_no) {
		this.road_no = road_no;
	}
	public long getSector_no() {
		return sector_no;
	}
	public void setSector_no(long sector_no) {
		this.sector_no = sector_no;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", road_no=" + road_no + ", sector_no=" + sector_no + "]";
	}
	
	
	

}
