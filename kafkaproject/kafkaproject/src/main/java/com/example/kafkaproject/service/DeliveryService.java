package com.example.kafkaproject.service;


import com.example.kafkaproject.kafkatopics.OrderTopics;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @KafkaListener(topics = OrderTopics.ORDER_STATUS, groupId = "delivery-group")
    public void consumeOrderStatus(String message) {
        System.out.println("DeliveryService received: " + message);
    }
}
