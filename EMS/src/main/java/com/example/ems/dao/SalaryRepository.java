package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.models.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{

}