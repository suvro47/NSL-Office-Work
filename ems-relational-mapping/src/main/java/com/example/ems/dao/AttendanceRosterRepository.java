package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.models.AttendanceRoster;

public interface AttendanceRosterRepository extends JpaRepository< AttendanceRoster, Long >{

}
