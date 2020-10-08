package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.models.SalaryBenefit;

@Repository
public interface SalaryBenefitRepository extends JpaRepository< SalaryBenefit , Long >{

}
