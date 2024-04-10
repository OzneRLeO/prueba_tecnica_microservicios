package com.prueba.tecnica.drools.product.infrastructure.rest.controller;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.drools.product.application.service.StockService;
import com.prueba.tecnica.drools.product.domain.model.Stock;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/stock")
@Slf4j
public class StockController {
	private final StockService stockService;
	
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
 
   @CircuitBreaker(name = "circuitBreakerService")
   @GetMapping("/find/{id}")
   public boolean StockCount(@PathVariable Integer id){
//	 AtomicReference<Boolean>  asw =  new AtomicReference<>(); 
 	 Mono<Stock> s =  this.stockService.getStockByProduct(id);  
 	 Mono<Boolean> sa = s.hasElement(); 
// 	 s.doOnNext(swq -> {
// 		 if(swq.getCantidad() <=0)
// 			asw.set(false);
// 		 else
// 			asw.set(true)	;
// 	 })
// 	 .block();
// 	 System.out.print("asw.set(false): " + asw.get()); 
	 return true;
   }
}
