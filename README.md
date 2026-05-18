A complete “Producers and Consumers” project in Java Spring Boot usually means implementing the classic concurrency pattern where:

Producer(s) generate messages/tasks/events
Consumer(s) process them asynchronously
A queue/broker sits in between

In modern Spring Boot, this is commonly done with:

in-memory queues (BlockingQueue)
or messaging systems like:
Apache Kafka
RabbitMQ
Apache ActiveMQ

I assume you meant Kafka (“kalka” → Kafka). Here’s a complete Spring Boot Kafka Producer–Consumer project.

spring-kafka-demo/
│
├── src/main/java/com/example/kafka/
│   ├── KafkaDemoApplication.java
│   ├── controller/
│   │     └── MessageController.java
│   ├── producer/
│   │     └── KafkaProducerService.java
│   ├── consumer/
│   │     └── KafkaConsumerService.java
│   ├── config/
│   │     └── KafkaConfig.java
│   └── model/
│         └── User.java
│
├── src/main/resources/
│     └── application.yml
│
└── pom.xml