package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.model.Customer;
import com.example.orderprocessingsystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer saved = service.addCustomer(customer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getAllCustomers();
    }
}

