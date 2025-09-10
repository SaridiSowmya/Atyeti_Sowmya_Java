package com.example.smartcartecommerce.controller;
import com.example.smartcartecommerce.model.Orders;
import com.example.smartcartecommerce.model.Product;
import com.example.smartcartecommerce.model.User;
import com.example.smartcartecommerce.repository.OrderRepository;
import com.example.smartcartecommerce.repository.ProductRepository;
import com.example.smartcartecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        Double revenue = orderRepo.totalRevenue();
        long orders = orderRepo.count();
        return Map.of("totalRevenue", revenue, "totalOrders", orders);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id,
            @RequestBody Product updated
    ) {
        return productRepo.findById(id)
                .map(product -> {
                    product.setName(updated.getName());
                    product.setCategory(updated.getCategory());
                    product.setPrice(updated.getPrice());
                    product.setStock(updated.getStock());
                    return ResponseEntity.ok(productRepo.save(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        return userRepo.findById(id)
                .map(user -> {
                    userRepo.delete(user);
                    return ResponseEntity.ok("User with id " + id + " deleted successfully");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User with id " + id + " not found"));
    }
}



