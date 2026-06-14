# Order Management System

A Spring Boot REST API application for managing customers and orders using MySQL and Spring Data JPA.

## Features

* Customer Management (CRUD)
* Order Management (CRUD)
* Customer-Order Relationship
* Input Validation
* Pagination
* Sorting
* MySQL Database Integration



## API Endpoints

### Customer

* POST /customers
* GET /customers
* PUT /customers/{id}
* DELETE /customers/{id}

### Order

* POST /orders
* GET /orders
* PUT /orders/{id}
* DELETE /orders/{id}

## How to Run

1. Create the MySQL database:

   ```sql
   CREATE DATABASE orderdb;
   ```

2. Configure database credentials in `application.properties`.

3. Run the application:

   ```
   mvn spring-boot:run
   ```

4. Test APIs using Postman or Thunder Client.


