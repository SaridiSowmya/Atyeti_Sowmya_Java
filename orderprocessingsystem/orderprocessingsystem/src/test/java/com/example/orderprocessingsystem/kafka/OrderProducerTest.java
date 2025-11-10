package com.example.orderprocessingsystem.kafka;
import com.example.orderprocessingsystem.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private OrderProducer orderProducer;

    @Test
    void testSendOrder() {
        Order order = new Order(1,1,1, 2, "CRETAED");
        orderProducer.sendOrder(order);
        verify(kafkaTemplate, times(1))
                .send(eq("order-topic1"), eq(order));
    }
}
