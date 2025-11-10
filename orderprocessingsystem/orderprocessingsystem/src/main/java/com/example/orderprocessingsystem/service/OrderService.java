package com.example.orderprocessingsystem.service;
import com.example.orderprocessingsystem.exception.InavalidOrderException;
import com.example.orderprocessingsystem.exception.ResourceNotFoundException;
import com.example.orderprocessingsystem.kafka.OrderProducer;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderProducer producer;

    public OrderService(OrderRepository repository, OrderProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public Order createOrder(Order order) {
       // return repository.save(order);

        if (order.getQuantity() <= 0) {
            throw new InavalidOrderException("Order quantity must be greater than zero");
        }
        Order savedOrder = repository.save(order);
        producer.sendOrder(savedOrder);
        return savedOrder;

    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }
}

