package org.example.kafkademo1.controller;

import org.example.kafkademo1.entiity.Message;
import org.example.kafkademo1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/new")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
    }
}
