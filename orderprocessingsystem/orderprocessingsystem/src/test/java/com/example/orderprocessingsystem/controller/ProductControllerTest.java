package com.example.orderprocessingsystem.controller;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.orderprocessingsystem.model.Product;
import com.example.orderprocessingsystem.service.ProductService;
import com.example.orderprocessingsystem.controller.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;


    @Test
    void testAddProduct() {
        Product product = new Product(1, "Laptop", 10, 50000.0);
        when(service.addProduct(product)).thenReturn(product);
        Product result = controller.addProduct(product).getBody();
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
        verify(service, times(1)).addProduct(product);
    }

    @Test
    void testGetProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 10, 50000.0),
                new Product(2, "Phone", 5, 20000.0)
        );
        when(service.getAllProducts()).thenReturn(products);
        List<Product> result = controller.getProducts();
        assertEquals(2, result.size());
        verify(service, times(1)).getAllProducts();
    }
}

