package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.model.Customer;
import com.example.orderprocessingsystem.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reactive/customers")
public class ReactiveCustomerController {

    private final CustomerService service;

    public ReactiveCustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Customer> getAll() {
        return Flux.fromIterable(service.getAllCustomers());
    }

//    @GetMapping("/{id}")
//    public Mono<Customer> getById(@PathVariable int id) {
//        return Mono.fromCallable(() -> service.getCustomerById(id));
//    }

    @PostMapping
    public Mono<Customer> addCustomer(@RequestBody Customer customer) {
        return Mono.fromCallable(() -> service.addCustomer(customer));
    }
}

