# JDBC Banking System

## Features

- Add Customer
- View Customers
- Update Customer Balance
- Delete Customer
- Transfer Money (Transaction Management)
- MySQL Integration using JDBC



## Database Setup

CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE customers (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

## JDBC Driver

mysql-connector-j-9.7.0.jar

## Run

1. Add JDBC driver to project.
2. Configure MySQL username and password in DBConnection.java.
3. Compile and run Main.java.

