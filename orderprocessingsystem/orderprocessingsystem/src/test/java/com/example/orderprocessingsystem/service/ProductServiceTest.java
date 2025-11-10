package com.example.orderprocessingsystem.service;
import com.example.orderprocessingsystem.model.Product;
import com.example.orderprocessingsystem.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void testAddProduct() {
        Product p = new Product(0, "Laptop", 10, 50000.0);
        Product saved = new Product(1, "Laptop", 10, 50000.0);
        when(repository.save(p)).thenReturn(saved);
        Product result = service.addProduct(p);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Laptop", result.getName());
        verify(repository, times(1)).save(p);
    }

    @Test
    void testGetAllProducts() {
        List<Product> list = Arrays.asList(
                new Product(1, "Laptop", 10, 50000.0),
                new Product(2, "Phone", 5, 25000.0)
        );
        when(repository.findAll()).thenReturn(list);
        List<Product> result = service.getAllProducts();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }
}
