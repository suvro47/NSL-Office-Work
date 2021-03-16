package com.spring.redis.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.model.Product;
import com.spring.redis.service.ProductService;

@RestController
public class AppController {
	
	@Autowired
	private ProductService productDao;
	
	@PostMapping("/product")
	public Product saveProduct( @RequestBody Product product ) {
		return productDao.save(product);
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct( @PathVariable int id ) {
		return productDao.findProductById(id);
	}
	
	@GetMapping("/products")
	public List<Object> getAllProduct(){
		return productDao.findAll();
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productDao.deleteProduct(id);
	}
	

}
