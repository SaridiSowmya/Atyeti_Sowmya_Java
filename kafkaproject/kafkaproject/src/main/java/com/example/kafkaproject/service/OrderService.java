package com.example.kafkaproject.service;

import com.example.kafkaproject.dto.OrderRequest;
import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.kafkatopics.OrderTopics;
import com.example.kafkaproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public String placeOrder(OrderRequest request) {
        Order order = new Order(request.getProductName(), request.getQuantity(), "PLACED");
        orderRepository.save(order);

        kafkaTemplate.send(OrderTopics.ORDERS, order.getProductName() + ":" + order.getQuantity());
        return "Order placed successfully for " + order.getProductName();
    }
}

