package com.product.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.manager.model.Product;
import com.product.manager.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> allProduct() {
		
		return productRepository.findAll();
	}
	
	public void saveProduct( Product product ) {
		productRepository.save(product);
	}
	
	public Product findById(Long id ) {
		return productRepository.findById(id).orElse( new Product());
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);	
	}
	

}
