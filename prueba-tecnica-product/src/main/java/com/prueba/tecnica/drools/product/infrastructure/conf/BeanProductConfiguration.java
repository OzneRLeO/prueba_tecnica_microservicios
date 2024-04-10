package com.prueba.tecnica.drools.product.infrastructure.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prueba.tecnica.drools.product.application.service.DomainProductService;
import com.prueba.tecnica.drools.product.application.service.ProductService;
import com.prueba.tecnica.drools.product.domain.port.ProductRepository;
import com.prueba.tecnica.drools.product.infrastructure.rest.mapper.ProductMapper;

@Configuration
public class BeanProductConfiguration {
	
	@Bean
	ProductService productBeanService(final ProductRepository productRepository) {
		return new DomainProductService(productRepository);
	}
	 
}
