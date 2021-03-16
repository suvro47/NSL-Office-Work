package com.spring.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.spring.redis.model.Product;

@Service
public class ProductService {
	
	public static final String HASH_KEY = "Product";
	
	@Autowired
	private RedisTemplate< String, ? > redisTemplate;
	
	public Product save( Product product) {
		redisTemplate.opsForHash().put( HASH_KEY ,product.getId() , product);
		return product;
	}
	
	public List<Object> findAll(){
		return redisTemplate.opsForHash().values(HASH_KEY);
	}
	
	public Product findProductById(int id) {
		return (Product) redisTemplate.opsForHash().get(HASH_KEY,id);
	}
	
	public String deleteProduct(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "product removed !!";
	}
	

}
