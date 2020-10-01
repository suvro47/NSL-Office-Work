package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{	
}
