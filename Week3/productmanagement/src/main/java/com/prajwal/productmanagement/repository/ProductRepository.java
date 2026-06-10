package com.prajwal.productmanagement.repository;

import com.prajwal.productmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}