package org.example.kafkademo1.service;

import org.example.kafkademo1.entiity.Message;

public interface MessageService {

    Message save(Message message);
}
