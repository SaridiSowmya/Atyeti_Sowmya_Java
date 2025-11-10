package com.example.orderprocessingsystem.kafka;
import com.example.orderprocessingsystem.model.Order;
import com.example.orderprocessingsystem.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderConsumerTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private NotificationProducer notificationProducer;

    @InjectMocks
    private OrderConsumer consumer;

    @Test
    void testConsumeOrder() {

        Order order = new Order(1, 1,1, 2, "PROCESSED");
        consumer.consumeOrder(order);
        assert(order.getStatus().equals("PROCESSED"));
        verify(repository, times(1)).save(order);
        verify(notificationProducer, times(1))
                .sendNotification("Order processed: " + order.getId());
    }
}

