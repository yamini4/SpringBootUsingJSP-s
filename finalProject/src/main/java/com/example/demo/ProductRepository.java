package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("select product from Product product where product.category_id=?1")
	List<Product> findByCategoryid(String cid);
	
}
