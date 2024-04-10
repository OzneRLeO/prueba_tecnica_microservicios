package com.prueba.tecnica.drools.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PruebaTecnicaStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaStockApplication.class, args);
	}

}
