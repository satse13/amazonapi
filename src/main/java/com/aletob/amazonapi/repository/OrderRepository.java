package com.aletob.amazonapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aletob.amazonapi.model.Order;

public interface OrderRepository extends CrudRepository<Order,Long>{
	
	Optional<Order> findById(Long id);
	List<Order> findByUserId(Long userId);
	List<Order> findByProductId(Long productId);
	
}
