package com.example.orderprocessingsystem.kafka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private NotificationProducer notificationProducer;


    @Test
    void testSendNotification() {
        String message = "Order processed successfully";
        notificationProducer.sendNotification(message);
        verify(kafkaTemplate, times(1))
                .send(eq("notification-topic"), eq(message));
    }
}

