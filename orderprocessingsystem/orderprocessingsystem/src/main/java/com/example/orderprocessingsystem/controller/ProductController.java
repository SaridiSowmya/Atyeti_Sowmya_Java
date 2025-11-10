package com.example.orderprocessingsystem.controller;
import com.example.orderprocessingsystem.model.Customer;
import com.example.orderprocessingsystem.model.Product;
import com.example.orderprocessingsystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = service.addProduct(product);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }
}

