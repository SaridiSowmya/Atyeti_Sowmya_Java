package com.example.kafka_producer.controller;

import com.example.kafka_producer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private KafkaMessagePublisher kafkamessagepublisher;
    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message)
    {

        try{
            for(int i=0;i<1000;i++) {
                kafkamessagepublisher.publishMessage(message +" "+i);
            }

            return ResponseEntity.ok("message published" +message);
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("error" +e.getMessage());

        }

    }

}
