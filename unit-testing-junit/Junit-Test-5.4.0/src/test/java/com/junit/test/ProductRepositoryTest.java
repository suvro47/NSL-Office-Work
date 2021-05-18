package com.junit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase( replace = Replace.NONE )
class ProductRepositoryTest {

	@Autowired
	private ProductRepository repo;
	
	@Test
    @Rollback(false) // to keep db changed
	void testCreateProduct() {
		Product product = new Product( "Polo tShirt", 500.00 );
		Product savedProduct = repo.save(product);
		assertNotNull(savedProduct);  // assume not null 
	}
	
	@Test
	void testFindProductByName() {
		String name = "Polo tShirt";
		Product product = repo.findByName(name);
		assertEquals( product.getName(), name);  // assume equal 
	}
	
	@Test
	void testFindProductByNameNotExist() {
		String name = "Polo Shirt";
		Product product = repo.findByName(name);
		assertNull(product);  // assume null 
	}
	
	@Test
	@Rollback(false) // to keep db updated
	void testUpdateProduct() {
		String name = "Pant";
		Product product = new Product(name,2000.00);
		product.setId(5L);  // put and id exist in db
		Product updatedProduct = repo.save(product);
		assertEquals(updatedProduct.getName(), name);
	}
	
	@Test
	void testDeleteProduct() {
		Long Id = 5L;  // put an id exist in db
		boolean isExistBeforeDelete = repo.findById(Id).isPresent();
		repo.deleteById(Id);
		boolean isExsitAfterDelete = repo.findById(Id).isPresent();
		assertTrue(isExistBeforeDelete);  // assuming as true
		assertFalse(isExsitAfterDelete); // assuming as false
	}
	

}
