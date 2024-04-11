package org.example.kafkademo1.service.impl;

import org.example.kafkademo1.entiity.Message;
import org.example.kafkademo1.repository.MessageRepository;
import org.example.kafkademo1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${application.kafka.topic}")
    private String topic;

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(KafkaTemplate<String, Object> kafkaTemplate, MessageRepository messageRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        kafkaTemplate.send(topic, message);
        return messageRepository.save(message);
    }
}
