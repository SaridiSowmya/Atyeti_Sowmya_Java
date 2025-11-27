package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.model.Product;
import com.example.orderprocessingsystem.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reactive/products")
public class ReactiveProductController {

    private final ProductService service;

    public ReactiveProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Product> getAll() {
        return Flux.fromIterable(service.getAllProducts());
    }

//    @GetMapping("/{id}")
//    public Mono<Product> getById(@PathVariable int id) {
//        return Mono.fromCallable(() -> service.getProductById(id));
//    }

    @PostMapping
    public Mono<Product> addProduct(@RequestBody Product product) {
        return Mono.fromCallable(() -> service.addProduct(product));
    }
}
