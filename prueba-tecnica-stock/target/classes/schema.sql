CREATE TABLE IF NOT EXISTS storage_libro.products  (
	product_id serial4 NOT NULL ,
	name VARCHAR   NULL ,
	price numeric   NULL ,	 
	CONSTRAINT product_id UNIQUE (product_id)
);

CREATE TABLE IF NOT EXISTS storage_libro.stock  (
	stock_id serial4 NOT NULL ,
	cantidad numeric   NULL ,
	product_id integer   NULL ,	 
	CONSTRAINT stock_id UNIQUE (stock_id),
	CONSTRAINT stock_products_fk FOREIGN KEY (product_id) REFERENCES storage_libro.products(product_id)
);
