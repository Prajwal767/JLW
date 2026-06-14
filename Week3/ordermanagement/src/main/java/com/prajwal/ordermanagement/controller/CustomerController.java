package com.prajwal.ordermanagement.controller;

import com.prajwal.ordermanagement.entity.Customer;
import com.prajwal.ordermanagement.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PutMapping("/{id}")
public Customer updateCustomer(@PathVariable Long id,
                               @RequestBody Customer updatedCustomer) {

    Customer customer = customerRepository.findById(id)
            .orElseThrow();

    customer.setName(updatedCustomer.getName());
    customer.setEmail(updatedCustomer.getEmail());

    return customerRepository.save(customer);
}

    @DeleteMapping("/{id}")
public String deleteCustomer(@PathVariable Long id) {

    customerRepository.deleteById(id);

    return "Customer deleted successfully";
}

}