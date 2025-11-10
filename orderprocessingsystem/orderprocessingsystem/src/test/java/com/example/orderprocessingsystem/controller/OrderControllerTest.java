package com.example.orderprocessingsystem.controller;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.service.OrderService;
import com.example.orderprocessingsystem.controller.OrderController;
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
class OrderControllerTest {

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    @Test
    void testCreateOrder() {
        Order order = new Order(1, 1, 2, 3, "CREATED");
        when(service.createOrder(order)).thenReturn(order);
        Order result = controller.createOrder(order);
        assertNotNull(result);
        assertEquals("CREATED", result.getStatus());
        verify(service, times(1)).createOrder(order);
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = Arrays.asList(
                new Order(1, 1, 2, 3, "CREATED"),
                new Order(2, 2, 3, 1, "CREATED")
        );
        when(service.getAllOrders()).thenReturn(orders);
        List<Order> result = controller.getAllOrders();
        assertEquals(2, result.size());
        verify(service, times(1)).getAllOrders();
    }

    @Test
    void testGetOrderById() {
        Order order = new Order(1, 1, 2, 3, "CREATED");
        when(service.getOrderById(1)).thenReturn(order);
        Order result = controller.getOrderById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(service, times(1)).getOrderById(1);
    }
}


