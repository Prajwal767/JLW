# Product Management REST API

## Features

- Add Product
- View All Products
- View Product By ID
- Update Product
- Delete Product

## API Endpoints

- POST /products
- GET /products
- GET /products/{id}
- PUT /products/{id}
- DELETE /products/{id}

## Run

1. Create MySQL database `productdb`
2. Configure database credentials in `application.properties`
3. Run:

```bash
mvnw.cmd spring-boot:run