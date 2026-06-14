package com.prajwal.ordermanagement.repository;

import com.prajwal.ordermanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}