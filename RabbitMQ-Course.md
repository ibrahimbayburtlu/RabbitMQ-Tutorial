# Welcome to the Free RabbitMQ Course

## Introduction

Welcome to this free RabbitMQ course! This course provides you with information about the fundamentals of RabbitMQ, the AMQP Protocol, and Message Queues. Whether you are a beginner or looking to expand your knowledge, this course is here to help you get started with RabbitMQ.

RabbitMQ is one of the most widely used Message Brokers globally, playing a critical role in building fast, reliable, and scalable applications. This educational tool equips you with the skills needed to harness this power.

### About Us

This online educational tool is provided by CloudAMQP, a service offering RabbitMQ since 2012. With extensive experience in setting up and managing RabbitMQ servers, this course is a result of our knowledge and insights from the community.

### Course Structure

Our goal is to make RabbitMQ more accessible and easy to adopt. The course is divided into sections that provide in-depth information on specific topics. After each section, you can take a quiz to test your knowledge. This will prepare you to earn your free RabbitMQ certificate.

### Course Features

- **Flexible Learning**: You are not required to follow a specific sequence. Exploring lessons in the order you choose is encouraged.
- **Quizzes**: Quizzes are optional, and your progress is personal.
- **Resources**: Below the video, you will find lesson notes, the full video content, and a discussion board where you can seek assistance.

## Course Introduction

Humanity has always had a need to communicate, and, of course, IT systems and software share the same necessity. At the core, it's about one service sending, another service receiving, and the message itself.

Sometimes the sender requires a swift response, while at other times, you may need to patiently wait for a reply, or perhaps expect no response at all.

Certainly, there are various means of communication, and this holds true for IT systems as well. One of these methods involves connecting two systems through a queue. Message Queuing allows applications to communicate by sending messages to each other.

The message queue serves as temporary message storage when the destination program is busy or not connected.

In the first section, we'll acquaint ourselves with Message Queuing and the necessary components to facilitate it. We'll delve into the advantages of using Message Queuing, explore its real-life applications, and take a closer look at the star of the show: RabbitMQ.

## Explaining Message Queues

Let's start off with the basics. This image shows a basic overview of a Message Queue and its components, the sending application, Message, Broker, Queue, and the receiving application.

The sending application, or service if you like, is known as the Publisher. It’s the part of the system that sends the message to the Broker.

These messages contains information that other applications can react to. The Producers are responsible for all messages coming into the system. The receiving application is known as the Consumer. It’s the part of a system that receives the message from the Message Queue. Messages in RabbitMQ are usually pushed from the broker to the consumers (recommended).

The Consumer is supposed to take action once it receives the message, whether it’s a task or information that needs to be processed.

A Broker is a software that acts as a middleman of the services, receiving messages from one service (Producers) and handing them over to others (Consumers) to complete the task.

The Message Broker itself can have one or many queues. And the Broker is a bit more complex than shown in this video but we will get into those details a bit later.

A Queue is a line of things waiting to be handled, starting at the beginning of the line and processing it in sequential order.

Messages are always added to the end of the Queue. This Queue is located within the Broker. A message is the data transported between the Publisher and the Consumer. Essentially, messages are byte arrays with some headers added on top.

An example of a message could be something that tells one system to start processing a task. It could contain information about a finished task, or it could just be a plain message.

## Message Queue Use Cases

This is an image scaling example that shows how this technology works in real life.

Imagine that we have a web application that allows users to upload a profile picture. Once the user has made their upload they can decide what part of the picture they want to use, if it should be scaled up or down, or if it should be moved.

When they are happy with the picture, they save the new settings. The web application sends the picture along with the settings to the part of the system responsible for "Image Processing". Which usually includes downsizing and optimization for the web.

Let’s take a look at how this works behind the scenes. This message is placed onto a Queue defined in the Message Broker. Messages are organized in the same order as they enter the queue: first-in-first-out (FIFO). The Consumer retrieves the message and handles the image scaling request.

## Advantages of Message Queueing

Let us introduce you to some basic terminology.

### Microservices and Decoupling

Microservices are a group of components that communicate using a centralized service, like a Message Queue.

The opposite of a Microservice System is referred to as a Monolith System and is instead communicating directly with other parts of the system. For that reason, microservice applications are often "Decoupled" while monolith applications are "Highly Coupled".

Also, using a message broker in your system means that you’re making the communication between the components Asynchronous. It’s much like when we’re sending an email, the response is sent when it's convenient.

The opposite of this is direct communication or "Synchronous" communication, which is more similar to when we’re chatting on the phone. The response is immediate and, when you hang up, the conversation is over.

### Advantages of Message Queueing

Asynchronous communication and decoupling within systems can be very beneficial. Here follow some advantages that show the benefits of having a Message Queue as part of the architecture.

#### Decoupling and Independence

The microservice system is decoupled and divided into two or more small services, where each microservice is developed separately. The sum of all microservices is what makes up the total application. When a system is decoupled, every microservice operates individually and doesn't have to relate to the others.

Because of that, different microservices can be written in different languages, be developed by different teams, and evolve independently.

#### Fault Tolerance

If one of the microservices goes down or for another reason is unavailable, the rest of the services in the system will still proceed with their tasks independently. This makes the application fault-tolerant and stable.

In a monolith system, on the other hand, a failure of one single service can cause problems or even make the entire application go down.

#### Message Storage and Redelivery

A system using a Message Queue offers temporary storage for messages waiting to be handled by a consumer. Publishers can, therefore, continue to produce messages without having to worry about the message itself. As long as messages hit the Queue, the message is safe within the Broker and suffers a minimal risk of getting lost.

If the consumer is not able to handle a message, the same message can be re-delivered multiple times until the consumer can process it successfully.

#### Fault-Tolerant Database Operations

Decoupling the database from the application and adding a Message Queue in between makes the application more fault-tolerant. If the database crashes, the consumer can pick up the data from the Broker and perform the database action at a later time.

#### Scalability

A highly scalable system means that it can be customized to handle the amount of workload required, at every given moment. When the system is under heavy load: you scale up, and if the workload decreases: you scale down.

Adding more consumers to an existing microservice system is helping to keep the queues short during peak hours, and you can remove consumers when they are not needed. You don’t have to build an over-dimensional system just to be able to handle peaks.

#### Resilience

A decoupled system is a resilient system meaning that it can recover quickly from difficult conditions. Since the use of Message Queues decouples your services, leaving them unaware and unbound of each other, the impact of a failure of one service won't affect the others.

A service can still publish messages to the Queue, and the messages will stay in the Queue until the failing service is up and running. This also applies when a service needs upgrading or if developers wish to add a new service to an already existing system.

#### Asynchronous Communication

Asynchronous communication within Message Queuing means that messages in the Queue don’t have to be processed immediately. Instead, it will be processed as soon as the assigned service is ready. This allows the system to carry on, serving you or other users, with the assurance that the task will be completed not immediately, but as soon as possible.

To clarify the extremes between synchronous and asynchronous communication: When shopping online, an asynchronous system will let you continue navigating the web shop after you place the order and hit send. The payment will be processed in the background, and the order confirmation will be sent to your email whenever possible.

On the other hand, the synchronous system would temporarily lock the web shop up until the system approves of all the series of events.

## Overview of the AMQP Protocol

RabbitMQ implements a widely used standard protocol known as AMQP, which stands for Advanced Message Queuing Protocol. Over the years, RabbitMQ has been extended to support additional protocols such as STOMP, MQTT, and more.

### Importance of Protocols

A protocol serves as a specification or standard, enabling electronic devices to communicate efficiently. It defines how data is sent based on a set of rules, which include commands for sending or receiving data, the types of data that can be transmitted, and methods to confirm successful data transfer.

Standard protocols are integral to our daily internet usage, facilitating communication between devices with different internal processes, structures, or designs. For example, protocols enable a Mac computer to access a website hosted on a Unix-based server (HTTP) or allow an iPhone to send emails to an Android device (SMTP).

### Focus on AMQP

AMQP remains the most widely used protocol and will be the primary focus of this course. To be compatible with RabbitMQ, it must adhere to rules governing how messages are routed and stored within the Broker.

AMQP specifies the intricacies of connection establishment, Broker behavior, and Queue declaration. Key features of AMQP include reliability and security considerations.

### Deeper Dive into AMQP

#### Queues, Connections, and Channels

- **Queue:** Serves as a message storage buffer for unconsumed messages.
- **Connection:** Establishes a connection between your service and the AMQP broker.
- **Channel:** Represents a virtual connection within the established connection. All messages traverse through channels, which can be multiplexed, allowing a single connection to have multiple channels.

#### Message Routing through Exchange

- Messages are not directly published to a Queue; instead, they are sent through an Exchange.
- An Exchange, like a mail delivery person, ensures that messages end up in the correct queue.
- Messages are routed to Queues based on Bindings between Queues and Exchanges and the Routing Key.
- The Routing Key is crucial for the Exchange to determine how to route the message to queues.

#### Message Structure and Acknowledgment

- Messages contain headers with defining properties such as durability and priority, in addition to their main content.
- AMQP clearly defines when responsibility for a message is transferred between different parts of the system.
- Acknowledging commands confirm that messages have been successfully transferred and processed.

#### Virtual Hosts (vhosts)

- Virtual hosts provide a means to separate applications in the broker.
- Users' access privileges to different vhosts may vary.
- Queues and Exchanges exist only within a specific vhost.

## How It Is All Connected

Let’s connect the concepts that we have learned so far. A Message Broker acts as a middleman between services who wish to communicate asynchronously by sending messages.

Messages are sent from a Producer. Messages are handled by a Consumer. The message itself contains information of various kind.The message sent from a Producer is placed on a Message Queue in sequential order inside the Broker before it gets handled by a Consumer.

The Broker uses a protocol that consists of a set of message capabilities. The message is sent from the Producer to the Queue, via a Connection and a Channel.

The Exchange ensures that a message ends up in the correct Queue.

A Binding connects the Exchange and the Queue.

Vhost provides a way to segregate applications using the same RabbitMQ instance.

Consumers fetch messages from the Queue and process them in sequential order.


## Try Sending Your First Message 

Now we will take a look at how to set up a Queue in the RabbitMQ management interface and send our first message. We will use the photo scaling application example.

The RabbitMQ Management is a user-friendly interface that allows you to monitor and handle your RabbitMQ server from a web browser.

First of all, I set up a Queue named “image_scaling_queue”. Then, I create an image scaling Exchange. For this example, I use a Direct Exchange, which is one of four Exchange types. I set up a Binding from the image scaling Exchange to the image scaling Queue with the routing key named "image_scaling".

I then publish a message to the images scaling exchange with the routing key "image_scaling". I now have one message ready in the queue.
