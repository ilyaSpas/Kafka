package org.example.kafkademo1.kafka;

import org.example.kafkademo1.entiity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerTest {

    @KafkaListener(topics = "test")
    public void listen(Message message) {
        System.out.println(message);
    }
}
