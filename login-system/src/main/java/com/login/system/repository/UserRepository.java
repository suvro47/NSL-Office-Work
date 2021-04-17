package com.login.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
