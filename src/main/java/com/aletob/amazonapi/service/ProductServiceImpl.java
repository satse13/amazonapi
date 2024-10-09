package com.aletob.amazonapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aletob.amazonapi.dto.ProductDTO;
import com.aletob.amazonapi.model.Product;
import com.aletob.amazonapi.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{


	private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		
		logger.info("Getting product by id: " + id);
		
		return productRepository.findById(id).map(product -> {
			return mapProductToProductDTO(product);
		}).orElse(null);

	}

	@Override
	public ProductDTO getProductByName(String name) {
		
		logger.info("Getting product by name: " + name);
		
		return productRepository.findByName(name).map(product -> {
			return mapProductToProductDTO(product);
		}).orElse(null);

	}

	@Override
	public List<ProductDTO> getProductByPrice(double price) {
		
		logger.info("Getting product by price: " + price);
		
		return productRepository.findByPrice(price).stream()
				.map(this::mapProductToProductDTO)
				.collect(Collectors.toList());

	}

	@Override
	public List<ProductDTO> getAllProducts() {
		
		logger.info("Getting all products");
		
		return StreamSupport.stream(productRepository.findAll().spliterator(), false)
				.map(this::mapProductToProductDTO)
				.collect(Collectors.toList());

	}

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		
		logger.info("Adding product: " + productDTO);
		
		Product product = mapProductDTOToProduct(productDTO);
		Product savedProduct = productRepository.save(product);
		return mapProductToProductDTO(savedProduct);

	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		
		logger.info("Updating product: " + productDTO);
		
		return productRepository.findById(productDTO.getId()).map(product -> {
			product.setName(productDTO.getName());
			product.setDescription(productDTO.getDescription());
			product.setPrice(productDTO.getPrice());
			product.setQuantity(productDTO.getQuantity());
			productRepository.save(product);
			return mapProductToProductDTO(product);
		}).orElse(null);

	}

	@Override
	public ProductDTO deleteProduct(ProductDTO productDTO) {
	
		logger.info("Deleting product: " + productDTO);
		
		Product product = mapProductDTOToProduct(productDTO);
		productRepository.delete(product);
		return productDTO;

	}

	private ProductDTO mapProductToProductDTO(Product product) {
		return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
	}

	private Product mapProductDTOToProduct(ProductDTO productDTO) {
		return new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getQuantity());
	}
	
}
