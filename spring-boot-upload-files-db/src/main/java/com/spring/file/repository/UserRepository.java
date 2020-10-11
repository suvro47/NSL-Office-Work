package com.spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

}
