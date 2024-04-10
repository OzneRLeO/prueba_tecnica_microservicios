package com.prueba.tecnica.drools.product.infrastructure.adapter;

 

 
import org.springframework.stereotype.Component;

 
import com.prueba.tecnica.drools.product.domain.model.Stock;
import com.prueba.tecnica.drools.product.domain.port.StockRepository; 
import com.prueba.tecnica.drools.product.infrastructure.entity.StockEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
 
public class StockRepositoryR2DBC implements StockRepository{

	private final StockCrudRepository stockCrudRepository; 
	
	public StockRepositoryR2DBC(StockCrudRepository stockCrudRepository ) {
		this.stockCrudRepository = stockCrudRepository; 
	}  

	@Override
	public Mono<Stock> getStockByProduct(Integer productId) {
		// TODO Auto-generated method stub
		return this.stockCrudRepository.findByProductId(productId).map(this::mapToStock);
	}

	protected Stock mapToStock(StockEntity companyEntity) {
        return Stock.builder()
                .id(companyEntity.getId()) 
                .cantidad(companyEntity.getCantidad()) 
                .productId(companyEntity.getProductId()) 
                .build();
    }
}
