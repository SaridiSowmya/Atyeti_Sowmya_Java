package com.example.orderprocessingsystem.service;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.model.Product;
import com.example.orderprocessingsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}

