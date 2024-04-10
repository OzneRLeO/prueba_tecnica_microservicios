package com.prueba.tecnica.drools.product.application.service;

 

import com.prueba.tecnica.drools.product.domain.model.Stock;

 
import reactor.core.publisher.Mono;

public interface StockService {
	   Mono<Stock> getStockByProduct(Integer productId); 
}
