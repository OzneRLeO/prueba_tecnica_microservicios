package com.prueba.tecnica.drools.product.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

 

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
 
import lombok.Builder;
import lombok.Data;
 

@Entity
@Table("public.stock") 
@Data
@Builder
public class StockEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("stock_id")
    private Long id; 
	@Column( "cantidad")
    private Integer cantidad;
	@Column( "product_id")
    private Integer productId;
	
    
   
}
