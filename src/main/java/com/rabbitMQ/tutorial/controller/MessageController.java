package com.rabbitMQ.tutorial.controller;

import com.rabbitMQ.tutorial.dto.MessageBody;
import com.rabbitMQ.tutorial.publisher.RabbitMQProducer;
import com.rabbitMQ.tutorial.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private RabbitMQProducer producer;

    private MessageService messageService;

    @Autowired
    public MessageController(RabbitMQProducer producer,MessageService messageService){
        this.producer = producer;
        this.messageService = messageService;
    }

    // http://localhost:8080/api/v1/publish/message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
    // http://localhost:8080/api/v1/saveMessage
    @GetMapping("/saveMessage")
    public String saveMessage(@RequestBody MessageBody messageBody){
        LOGGER.info("Message save database :) ");
        return messageService.saveMessage(messageBody);
    }
}
