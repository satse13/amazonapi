package com.aletob.amazonapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aletob.amazonapi.dto.OrderDTO;
import com.aletob.amazonapi.model.Order;
import com.aletob.amazonapi.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{

	private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	private final OrderRepository orderRepository;


	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public OrderDTO getOrderById(Long id) {
		
		logger.info("Getting order by id: " + id);
		
		return orderRepository.findById(id).map(order -> {
			return mapOrderToOrderDTO(order);
		}).orElse(null);
	}

	@Override
	public List<OrderDTO> getOrdersByUser(Long userId) {
			logger.info("Getting orders by user: " + userId);
			return orderRepository.findByUserId(userId).stream()
							.map(this::mapOrderToOrderDTO)
							.collect(Collectors.toList());
	}

	@Override
	public List<OrderDTO> getOrdersByProduct(Long productId) {
			logger.info("Getting orders by product: " + productId);
			return orderRepository.findByProductId(productId).stream()
							.map(this::mapOrderToOrderDTO)
							.collect(Collectors.toList());
	}

	@Override
	public OrderDTO createOrder(OrderDTO orderDTO) {
			logger.info("Creating order: " + orderDTO);
			Order order = mapOrderDTOToOrder(orderDTO);
			Order savedOrder = orderRepository.save(order);
			return mapOrderToOrderDTO(savedOrder);
	}

	@Override
	public OrderDTO updateOrder(OrderDTO orderDTO) {
			logger.info("Updating order: " + orderDTO);
			Order order = mapOrderDTOToOrder(orderDTO);
			Order updatedOrder = orderRepository.save(order);
			return mapOrderToOrderDTO(updatedOrder);
	}

	@Override
	public OrderDTO deleteOrder(OrderDTO orderDTO) {
			logger.info("Deleting order: " + orderDTO);
			Order order = mapOrderDTOToOrder(orderDTO);
			orderRepository.delete(order);
			return orderDTO;
	
	}

	private Order mapOrderDTOToOrder(OrderDTO orderDTO) {
		return new Order(orderDTO.getId(), orderDTO.getUserId(), orderDTO.getProductId(), orderDTO.getQuantity());
	}
	
	private OrderDTO mapOrderToOrderDTO(Order order) {
		return new OrderDTO(order.getId(), order.getUserId(), order.getProductId(), order.getQuantity());
	}

}
