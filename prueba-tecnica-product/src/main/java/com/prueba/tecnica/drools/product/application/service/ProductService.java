package com.prueba.tecnica.drools.product.application.service;

 

import com.prueba.tecnica.drools.product.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
		Flux<Product> getProducts();
//	    Mono<Product> update(Long id, Product product);
	    Mono<Product> getProductById(Long id);
	    Mono<Product> saveProduct(Product product);
	    Mono<Void> deleteProduct(Long id);
}
