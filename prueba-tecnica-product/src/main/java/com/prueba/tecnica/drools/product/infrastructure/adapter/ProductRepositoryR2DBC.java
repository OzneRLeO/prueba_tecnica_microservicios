package com.prueba.tecnica.drools.product.infrastructure.adapter;

 

 
import org.springframework.stereotype.Component;
 

import com.prueba.tecnica.drools.product.domain.model.Product;
import com.prueba.tecnica.drools.product.domain.port.ProductRepository;
import com.prueba.tecnica.drools.product.infrastructure.entity.ProductEntity; 
 
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
 
public class ProductRepositoryR2DBC implements ProductRepository{

	private final ProductCrudRepository productCrudRepository;
//	private final ProductMapper productMapper;
//	@Autowired(required = true)
//	private ProductMapper productMapper;
	
	public ProductRepositoryR2DBC(ProductCrudRepository productCrudRepository ) {
		this.productCrudRepository = productCrudRepository;
//		this.productMapper = productMapper;
	}
	
	
	
	@Override
	public Flux<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.productCrudRepository.findAll().map(this::mapToProduct);  
	}

	@Override
	public Mono<Product> getProductById(Long id) {
		// TODO Auto-generated method stub 
 		return this.productCrudRepository.findById(id).map(this::mapToProduct);
	}

	@Override
	public Mono<Product> saveProduct(Product product) {
		// TODO Auto-generated method stub
	 
		return this.productCrudRepository.save(ProductEntity.builder()
			    .id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.build()).map(this::mapToProduct);
	}

	@Override
	public Mono<Void> deleteProductByID(Long id) {
		// TODO Auto-generated method stub
		return this.productCrudRepository.deleteById(id);
	}
	
	protected Product mapToProduct(ProductEntity companyEntity) {
        return Product.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .price(companyEntity.getPrice()) 
                .build();
    }
	
	 protected ProductEntity mapToCompanyEntity(Product product) {
	        return ProductEntity.builder()
	        		  .id(product.getId())
	                  .name(product.getName())
	                  .price(product.getPrice())  
	                .build();
	    }

}
