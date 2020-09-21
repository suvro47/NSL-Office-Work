package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Alien;


public interface AlienRepo  extends JpaRepository<Alien, Integer> {
}
