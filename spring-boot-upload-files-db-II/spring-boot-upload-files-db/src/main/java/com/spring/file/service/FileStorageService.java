package com.spring.file.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.file.model.AppUser;
import com.spring.file.model.File;
import com.spring.file.repository.FileRepository;
import com.spring.file.repository.UserRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileRepository fileDBRepository;
	
	@Autowired
	UserRepository repo;

	public File store(int id, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		File File = new File(fileName, file.getContentType(), file.getBytes());
		fileDBRepository.save(File);
		Optional<AppUser> OpUser =  repo.findById(id);
		AppUser user = OpUser.get();
		user.setFile(File);
		repo.save(user);
		return fileDBRepository.save(File);
	}

	public File getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	public Stream<File> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
	
	

}
