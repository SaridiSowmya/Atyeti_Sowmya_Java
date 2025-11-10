package com.example.orderprocessingsystem.kafka;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.repository.OrderRepository;
//import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class OrderConsumer {

    private final OrderRepository repository;
    private final NotificationProducer notificationProducer;

    public OrderConsumer(OrderRepository repository, NotificationProducer notificationProducer) {
        this.repository = repository;
        this.notificationProducer = notificationProducer;
    }

    @KafkaListener(topics = "order-topic1", groupId = "ordersystem1-group")
    public void consumeOrder(Order order) {
        order.setStatus("PROCESSED");
        repository.save(order);
        notificationProducer.sendNotification("Order processed: " + order.getId());
    }
}

