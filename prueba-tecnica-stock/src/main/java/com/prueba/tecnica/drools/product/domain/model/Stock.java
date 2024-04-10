package com.prueba.tecnica.drools.product.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data  
@Builder
public class Stock {
    private Long id;  
    private Integer cantidad;
    private Integer productId; 
    
}
