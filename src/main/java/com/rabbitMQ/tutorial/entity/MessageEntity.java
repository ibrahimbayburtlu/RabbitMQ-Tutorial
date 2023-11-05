package com.rabbitMQ.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rabbitMQTable")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_name")
    String name;

    @Column(name = "text")
    String text;
}
