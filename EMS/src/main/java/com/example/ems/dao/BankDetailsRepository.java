package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.models.BankDetails;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long>{

}
