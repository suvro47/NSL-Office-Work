package com.spring.rest.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.spring.rest.model.AppUser;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {
	
	HashMap<String,AppUser> db = new HashMap<>();

	@Override
	public AppUser save(AppUser user) {
		db.put(user.getEmail(), user);
		return user;
	}

	@Override
	public AppUser findByEmail(String email) {
		if( db.containsKey(email) ) return null;
		return db.get(email);
	}

}
