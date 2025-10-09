package com.example.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
   private KafkaTemplate<String,Object> kafkatemplate;
    public void publishMessage(String message) {

      CompletableFuture<SendResult<String,Object>> future=kafkatemplate.send("test2",message);

      future.whenComplete((result,ex)-> {
          if(ex!=null) {
              System.err.println("error sending message"+message);
          }
          else{
              System.out.println("message sent succesfully"+result.getProducerRecord().value());
          }
      });
    }
}
