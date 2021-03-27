package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UzerRepository extends JpaRepository<Uzer, Long>{
	
	Uzer findByUsername( String username);

}
