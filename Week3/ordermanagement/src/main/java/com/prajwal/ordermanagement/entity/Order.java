package com.prajwal.ordermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String productName;

    @Min(value = 1, message = "Amount must be greater than 0")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(Long id, String productName, double amount, Customer customer) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}