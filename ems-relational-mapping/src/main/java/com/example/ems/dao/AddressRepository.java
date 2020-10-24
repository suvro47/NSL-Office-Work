package com.example.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ems.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	@Query(value="select * from address where sector_no = ?1 ", nativeQuery=true)
	public List<Address> findAddressSectorNo(int sn);
	
}
