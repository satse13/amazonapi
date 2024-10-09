package com.aletob.amazonapi.service;


import java.util.List;

import com.aletob.amazonapi.dto.OrderDTO;

public interface OrderService {
	
	OrderDTO getOrderById(Long id);
	List<OrderDTO> getOrdersByUser(Long userId);
	List<OrderDTO> getOrdersByProduct(Long productId);
	OrderDTO createOrder(OrderDTO orderDTO);
	OrderDTO updateOrder(OrderDTO orderDTO);
	OrderDTO deleteOrder(OrderDTO orderDTO);
	
}
