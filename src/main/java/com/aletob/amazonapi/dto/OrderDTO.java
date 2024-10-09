package com.aletob.amazonapi.dto;

public class OrderDTO {
	
	private Long id;
	private Long userId;
	private Long productId;
	private int quantity;


	public OrderDTO() {
	}

	public OrderDTO(Long id, Long userId, Long productId, int quantity) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDTO [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
