
# Editor.md

 


**Table of Contents**

[TOCM]

[TOC]
 
-------------
### Indicaciones
- Todo los proyectos usan Spring boot 3 y Java 17


  

###Codigo de SQL  
 Se crean las tablas y data en Postgres, en el aplicativo se usa R2DBC para la reactividad
 
####Crear Tablas　

```javascript
CREATE TABLE IF NOT EXISTS public.products  (
	product_id serial4 NOT NULL ,
	name VARCHAR   NULL ,
	price numeric   NULL ,
	CONSTRAINT product_id UNIQUE (product_id)
);

CREATE TABLE IF NOT EXISTS public.stock  (
	stock_id serial4 NOT NULL ,
	cantidad numeric   NULL ,
	product_id integer   NULL ,
	CONSTRAINT stock_id UNIQUE (stock_id),
	CONSTRAINT stock_products_fk FOREIGN KEY (product_id) REFERENCES public.products(product_id)
);

```

####Insertar data　

```javascript
insert into public.products (name, price) values ('product 1', 100);
insert into public.products (name, price) values ('product 2', 100);
insert into public.products (name, price) values ('product 3', 100);

insert into public.stock (cantidad , product_id) values (10, 1);
insert into public.stock (cantidad, product_id) values (20, 2);
insert into public.stock (cantidad, product_id) values (40, 3);

```
####Proyectos
- Se emplea 4 proyectos:

 - prueba-tecnica-discover-server (Servidor Eureka de microservicios)
 - prueba-tecnica-product (Microservicio A)
 - prueba-tecnica-stock (Microservicio B)
 - prueba-tecnica-gateway-servidor (Puerta de enlace)

El orden para levantar los proyectos son iniciando desde prueba-tecnica-discover-server  y terminando con  prueba-tecnica-gateway-servidor. Los microservicios A y B en medio de los mencionados.

El proyecto  prueba-tecnica-discover-server  se ocupara de la gestion de los microservicios A y B

####Endpoints
 De haber levantado el proyecto prueba-tecnica-gateway-servidor, se podra acceder a los microservicios mediante http://localhost:8099.
 
http://localhost:8099/api/productos/all
http://localhost:8099/api/productos/find/{id}
http://localhost:8099/api/products/save 
http://localhost:8099/api/products/delete/{id}
http://localhost:8099/api/stock/find/{id}

 Para el endpoint save  se usa el sgte json de plantilla:
 {
	"name":"Product_x",
	"price": 99.9
}

El servidor Eureka estara en el http://localhost:8761/eureka

 Caso donde se acceda a cada uno de los microservicios se usara los siguientes:
 http://localhost:8089/api/productos/all
http://localhost:8089/api/productos/find/{id}
http://localhost:8089/api/products/save
http://localhost:8089/api/products/delete/{id}
http://localhost:8088/api/stock/find/{id}
 
 Para el endpoint save (es un POST) se usa el sgte json de plantilla:
 {
	"name":"Product_x",
	"price": 99.9
}
 Para los endpoint terminando en {id} se reemplaza por numero de registro de la secciones Insertar Data (para este caso son solo 1,2 o 3).
 
Las reglas de Drools no pude añadirlos, pero estoy aún trabajando para incluirlos. Asi mismo como adicionales validaciones 
###End
