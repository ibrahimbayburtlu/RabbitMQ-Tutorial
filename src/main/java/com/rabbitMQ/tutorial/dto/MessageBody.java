package com.rabbitMQ.tutorial.dto;

import lombok.Data;

@Data
public class MessageBody {

    int id;
    String userName;
    String text;

    public MessageBody(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }
}
