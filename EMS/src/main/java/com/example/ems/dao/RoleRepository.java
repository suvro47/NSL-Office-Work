package com.example.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
