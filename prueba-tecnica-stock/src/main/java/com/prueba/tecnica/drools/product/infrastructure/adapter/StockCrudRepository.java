package com.prueba.tecnica.drools.product.infrastructure.adapter;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.prueba.tecnica.drools.product.domain.model.Stock;
import com.prueba.tecnica.drools.product.infrastructure.entity.StockEntity;

import reactor.core.publisher.Mono;

public interface StockCrudRepository extends R2dbcRepository<StockEntity, Long>{
	  Mono<StockEntity> findByProductId(Integer productId); 
}
