package com.prueba.tecnica.drools.product.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "stock-microservice")
public interface StockClient {
	
	@RequestMapping("/api/stocks/find/{id}")
	boolean StockCount(@PathVariable Integer id);
}
