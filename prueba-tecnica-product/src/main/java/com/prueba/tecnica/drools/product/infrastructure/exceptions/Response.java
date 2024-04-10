package com.prueba.tecnica.drools.product.infrastructure.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Response {
	 private List<Error> errors = new ArrayList<>();

	    public void addError(Error error) {
	        this.errors.add(error);
	    }

	    ;
}
