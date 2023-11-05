package com.rabbitMQ.tutorial.service;

import com.rabbitMQ.tutorial.dto.MessageBody;
import com.rabbitMQ.tutorial.entity.MessageEntity;
import com.rabbitMQ.tutorial.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    private MessageEntity messageEntity;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public String saveMessage(MessageBody messageBody){
        MessageEntity messageEntity1 = new MessageEntity();
        messageEntity1.setName(messageBody.getUserName());
        messageEntity1.setText(messageBody.getText());
        messageRepository.save(messageEntity1);
        return "me too";
    }
}
