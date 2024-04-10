package com.prueba.tecnica.drools.product.domain.port;

import org.springframework.data.jpa.repository.Query;

import com.prueba.tecnica.drools.product.domain.model.Stock;

 
import reactor.core.publisher.Mono;

public interface StockRepository { 
	@Query("select * from public.stock where product_id = :productId")
    Mono<Stock> getStockByProduct(Integer productId); 
}
