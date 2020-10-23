package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;

public interface UserRepo extends CrudRepository< User, Integer>{

}
