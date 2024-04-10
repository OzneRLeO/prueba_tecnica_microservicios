package com.prueba.tecnica.drools.product.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.prueba.tecnica.drools.product.domain.model.Product;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table("public.products") 
@Data 
@Builder
public class ProductEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("product_id")
    private Long id; 
	@Column( "name")
    private String name;
	@Column( "price")
    private Double price;
    
   
}
