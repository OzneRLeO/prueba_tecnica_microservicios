package com.prueba.tecnica.drools.product.infrastructure.adapter;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.prueba.tecnica.drools.product.infrastructure.entity.ProductEntity;

public interface ProductCrudRepository extends R2dbcRepository<ProductEntity, Long>{

}
