package com.aletob.amazonapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aletob.amazonapi.model.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
	
	Optional<Product> findByTitle(String title);
	Optional<Product> findByPrice(double price);
	Optional<Product> findByCategory(String category);
	
}
