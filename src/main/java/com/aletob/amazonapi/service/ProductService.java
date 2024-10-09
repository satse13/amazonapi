package com.aletob.amazonapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aletob.amazonapi.dto.ProductDTO;

@Service
public interface ProductService {

		ProductDTO getProductById(Long id);	
		ProductDTO getProductByName(String name);
		List<ProductDTO> getProductByPrice(double price);
		List<ProductDTO> getAllProducts();
		ProductDTO addProduct(ProductDTO productDTO);
		ProductDTO updateProduct(ProductDTO productDTO);
		ProductDTO deleteProduct(ProductDTO productDTO);
} 
	

