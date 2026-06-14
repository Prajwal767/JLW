package com.prajwal.ordermanagement.repository;

import com.prajwal.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}