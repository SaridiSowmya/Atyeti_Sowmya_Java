package com.example.smartcartecommerce.controller;
import com.example.smartcartecommerce.model.Product;
import com.example.smartcartecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> list() {
        return productService.list();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id) {
        return productService.get(id);
    }

    @GetMapping("/category/{cat}")
    public List<Product> byCategory(@PathVariable String cat) {
        return productService.byCategory(cat);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> create(@RequestBody Product p) {
        return ResponseEntity.ok(productService.add(p));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product p) {
        Product existing = productService.get(id);
        existing.setName(p.getName()); existing.setCategory(p.getCategory());
        existing.setPrice(p.getPrice()); existing.setStock(p.getStock());
        return ResponseEntity.ok(productService.add(existing));
    }
}

