package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.models.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}