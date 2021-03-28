package com.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
