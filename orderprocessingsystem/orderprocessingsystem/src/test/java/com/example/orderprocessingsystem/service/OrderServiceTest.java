package com.example.orderprocessingsystem.service;
import com.example.orderprocessingsystem.exception.InavalidOrderException;
import com.example.orderprocessingsystem.exception.ResourceNotFoundException;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.kafka.OrderProducer;
import com.example.orderprocessingsystem.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private OrderRepository repository;

    @Mock
    private OrderProducer producer;

    @InjectMocks
    private OrderService service;

    @Test
    void testCreateOrder_Success() {
        Order order = new Order(0, 1, 1, 2, "CREATED");
        Order savedOrder = new Order(1, 1, 1, 2, "CREATED");
        when(repository.save(order)).thenReturn(savedOrder);
        Order result = service.createOrder(order);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(repository, times(1)).save(order);
        verify(producer, times(1)).sendOrder(savedOrder);
    }


    @Test
    void testGetAllOrders() {
        List<Order> list = Arrays.asList(
                new Order(1, 1, 1, 10, "CREATED"),
                new Order(2, 2, 2, 2, "CREATED")
        );
        when(repository.findAll()).thenReturn(list);
        List<Order> result = service.getAllOrders();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetOrderById_Found() {
        Order order = new Order(1, 1, 1, 2, "CREATED");
        when(repository.findById(1)).thenReturn(Optional.of(order));
        Order result = service.getOrderById(1);
        assertEquals(1, result.getProductId());
        verify(repository, times(1)).findById(1);
    }

}
