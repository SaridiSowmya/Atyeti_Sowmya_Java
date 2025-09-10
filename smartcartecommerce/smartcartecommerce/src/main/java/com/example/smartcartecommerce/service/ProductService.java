package com.example.smartcartecommerce.service;

import com.example.smartcartecommerce.exception.ResourceNotFoundException;
import com.example.smartcartecommerce.model.Product;
import com.example.smartcartecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;

    public Product add(Product p) {
        return productRepo.save(p);
    }
    public List<Product> list() {
        return productRepo.findAll();
    }
    public Product get(int id) {
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
    public List<Product> byCategory(String category) {
        return productRepo.findByCategory(category);
    }
    public void reduceStock(Product p, int qty) {
        p.setStock(p.getStock() - qty);
        productRepo.save(p);
    }
}
