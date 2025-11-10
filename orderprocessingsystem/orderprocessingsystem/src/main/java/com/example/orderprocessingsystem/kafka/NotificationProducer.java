package com.example.orderprocessingsystem.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {
    private static final String TOPIC = "notification-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println(" Notification sent: " + message);
    }
}

