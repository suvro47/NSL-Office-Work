package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	// getUsers()
	// getUser(id)
	// addUser(user)
	// DeleteUser(id)
	// putUser(id,user)
	
	
	List<User> findByName(String name);
	

}
