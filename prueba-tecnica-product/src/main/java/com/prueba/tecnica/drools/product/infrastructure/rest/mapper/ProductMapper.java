package com.prueba.tecnica.drools.product.infrastructure.rest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import com.prueba.tecnica.drools.product.domain.model.Product;
 

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
 
@Mapper(componentModel = "spring")
public interface ProductMapper {
//	@Mappings({ 
//	      @Mapping(source = "id", target = "id"), 
//          @Mapping(source = "name", target = "name")
//	})
//	Mono<Product> toProduct(Mono<ProductEntity> producto); 
//    Flux<Product> toProducts(Flux<ProductEntity> productoEntity);
//
//    @InheritInverseConfiguration
//    ProductEntity toProductEnity (Product product);
}