package com.example.demo.repository;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddRepo extends JpaRepository<Address, Long>{

}
