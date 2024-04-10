package com.prueba.tecnica.drools.product.infrastructure.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.prueba.tecnica.drools.product.application.service.ProductService;
import com.prueba.tecnica.drools.product.domain.model.Product;
 

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/productos")
@Slf4j
public class ProductController {
	private final ProductService productService;
//	@Autowired
//    private StockClient stockClient;
// 
	   
	public ProductController(ProductService productService    ) {
		this.productService = productService; 
	}
	
   @CircuitBreaker(name = "circuitBreakerService")	
   @GetMapping("/all")
    public ResponseEntity<Flux<Product>> getProducts(){
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }
   
   @CircuitBreaker(name = "circuitBreakerService")
   @GetMapping("/find/{id}")
   public ResponseEntity<Mono<Product>> getProduct(@PathVariable Long id){
       return new ResponseEntity<>(this.productService.getProductById(id), HttpStatus.OK);
   }
   
   @CircuitBreaker(name = "circuitBreakerService")
   @PostMapping("/save")
   public ResponseEntity<Mono<Product>> saveProduct(@RequestBody Product product){ 
	   
//	   boolean inStock = stockClient.StockCount(Integer.valueOf(product.getId().toString())); 
//	   Error error = new Error();
//       if(!inStock) {  
//    	   new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//       } 
	   
    		return  new ResponseEntity<>( this.productService.saveProduct(product), HttpStatus.CREATED);
    		   
   }
   
   @CircuitBreaker(name = "circuitBreakerService")
   @DeleteMapping("/delete/{id}")
   public  Mono<Void> deleteProduct(@PathVariable Long id){
       return this.productService.deleteProduct(id);
   }
}
