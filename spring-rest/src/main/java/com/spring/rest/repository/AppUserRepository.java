package com.spring.rest.repository;

import com.spring.rest.model.AppUser;

public interface AppUserRepository {

	public AppUser save(AppUser user);
	public AppUser findByEmail(String email);
	
	
}
