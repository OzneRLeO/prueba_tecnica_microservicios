package com.prueba.tecnica.drools.product.application.service;

import org.springframework.stereotype.Component;

import com.prueba.tecnica.drools.product.domain.model.Product;
import com.prueba.tecnica.drools.product.domain.port.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


 
public class DomainProductService implements ProductService {
	
	private final ProductRepository productRepository;
	
	public DomainProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Flux<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.getProducts();
	}

	@Override
	public Mono<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return this.productRepository.getProductById(id);
	}

	@Override
	public Mono<Product> saveProduct(Product product) {
		// TODO Auto-generated method stub
		return this.productRepository.saveProduct(product);
	}

	@Override
	public Mono<Void> deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return this.productRepository.deleteProductByID(id);
	}
	
	 
 

}
