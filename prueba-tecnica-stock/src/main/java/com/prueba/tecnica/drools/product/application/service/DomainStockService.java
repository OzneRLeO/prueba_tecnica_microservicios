package com.prueba.tecnica.drools.product.application.service;

 

import com.prueba.tecnica.drools.product.domain.model.Stock;
import com.prueba.tecnica.drools.product.domain.port.StockRepository;

 
import reactor.core.publisher.Mono;


 
public class DomainStockService implements StockService {
	
	private final StockRepository stockRepository;
	
	public DomainStockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	} 
 
	@Override
	public Mono<Stock> getStockByProduct(Integer productId) {
		// TODO Auto-generated method stub
		return stockRepository.getStockByProduct(productId);
	}
	
	 
 

}
