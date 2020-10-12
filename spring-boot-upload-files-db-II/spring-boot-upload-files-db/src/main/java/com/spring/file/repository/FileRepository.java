package com.spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
}
