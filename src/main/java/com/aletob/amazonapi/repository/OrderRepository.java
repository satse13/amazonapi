package com.aletob.amazonapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aletob.amazonapi.model.Order;
import com.aletob.amazonapi.model.Product;
import com.aletob.amazonapi.model.User;

public interface OrderRepository extends CrudRepository<Order,Long>{
	
	Optional<Order> findByUser(User user);
	Optional<Order> findByProduct(Product product);
	
}
