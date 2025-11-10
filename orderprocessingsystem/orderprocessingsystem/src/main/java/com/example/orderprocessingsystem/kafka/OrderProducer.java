package com.example.orderprocessingsystem.kafka;
import com.example.orderprocessingsystem.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private static final String ORDER_TOPIC = "order-topic1";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send(ORDER_TOPIC, order);
        System.out.println(" Order sent to Kafka: " + order);
    }
}

