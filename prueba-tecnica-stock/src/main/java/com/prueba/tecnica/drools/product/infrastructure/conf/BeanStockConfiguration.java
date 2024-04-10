package com.prueba.tecnica.drools.product.infrastructure.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prueba.tecnica.drools.product.application.service.DomainStockService;
import com.prueba.tecnica.drools.product.application.service.StockService;
import com.prueba.tecnica.drools.product.domain.port.StockRepository;
 
@Configuration
public class BeanStockConfiguration {
	
	@Bean
	StockService stockBeanService(final StockRepository stockRepository) {
		return new DomainStockService(stockRepository);
	}
	 
}
