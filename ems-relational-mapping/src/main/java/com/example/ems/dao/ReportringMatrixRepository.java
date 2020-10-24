package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.models.ReportingMatrix;

@Repository
public interface ReportringMatrixRepository extends JpaRepository<ReportingMatrix, Long>{
	
	
}
