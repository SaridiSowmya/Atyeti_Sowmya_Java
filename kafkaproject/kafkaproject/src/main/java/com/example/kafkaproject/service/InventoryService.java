package com.example.kafkaproject.service;



import com.example.kafkaproject.kafkatopics.OrderTopics;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public InventoryService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = OrderTopics.ORDERS, groupId = "inventory-group")
    public void consumeOrder(String message) {
        System.out.println("InventoryService received: " + message);
        kafkaTemplate.send(OrderTopics.ORDER_STATUS, "Order confirmed for: " + message);
    }
}
