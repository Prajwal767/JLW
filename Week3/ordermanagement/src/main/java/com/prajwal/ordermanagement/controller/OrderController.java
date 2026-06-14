package com.prajwal.ordermanagement.controller;

import com.prajwal.ordermanagement.entity.Order;
import com.prajwal.ordermanagement.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create Order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Get All Orders with Pagination and Sorting
    @GetMapping
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return orderRepository.findAll(
                PageRequest.of(page, size, Sort.by(sortBy))
        );
    }

    // Update Order
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,
                             @RequestBody Order updatedOrder) {

        Order order = orderRepository.findById(id)
                .orElseThrow();

        order.setProductName(updatedOrder.getProductName());
        order.setAmount(updatedOrder.getAmount());
        order.setCustomer(updatedOrder.getCustomer());

        return orderRepository.save(order);
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderRepository.deleteById(id);

        return "Order deleted successfully";
    }
}