package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reactive/orders")
public class ReactiveOrderController {

    private final OrderService service;

    public ReactiveOrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return Flux.fromIterable(service.getAllOrders());
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrder(@PathVariable int id) {
        return Mono.fromCallable(() -> service.getOrderById(id));
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return Mono.fromCallable(() -> service.createOrder(order));
    }
}

