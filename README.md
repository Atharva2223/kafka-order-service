# Kafka Order Service

A simple event-driven application built using **Java, Spring Boot, Apache Kafka, Docker, and Maven** to demonstrate producer-consumer architecture and asynchronous message processing.

## Overview

This project simulates an order processing workflow where a client submits an order through a REST API. The application publishes the order as an event to a Kafka topic, and a consumer asynchronously processes the event.

The project was built to understand:

* Event-driven architecture
* Kafka Producers
* Kafka Consumers
* Topics
* Serialization & Deserialization
* Spring Boot integration with Kafka
* Asynchronous communication

---

## Architecture

```text
Client
   |
POST /orders
   |
   V
OrderController
   |
   V
OrderProducer
   |
   V
Kafka Topic (orders)
   |
   V
OrderConsumer
```

---

## Technologies Used

* Java 17
* Spring Boot
* Apache Kafka
* Docker
* Maven
* Lombok

---

## Project Structure

```text
src/main/java/com/atharva/kafka

├── controller
│   └── OrderController.java
│
├── producer
│   └── OrderProducer.java
│
├── consumer
│   └── OrderConsumer.java
│
├── model
│   └── OrderEvent.java
│
└── KafkaOrderServiceApplication.java
```

---

## Components

### OrderController

Receives HTTP requests and creates order events.

Endpoint:

```http
POST /orders
```

---

### OrderProducer

Publishes order events to Kafka.

Uses:

```java
KafkaTemplate<String, OrderEvent>
```

to send messages to the Kafka topic.

---

### Kafka Topic

Topic Name:

```text
orders
```

Stores order events published by the producer.

---

### OrderConsumer

Consumes order events from Kafka using:

```java
@KafkaListener
```

and processes them asynchronously.

---

### OrderEvent

Represents the Kafka message payload.

Example:

```json
{
  "orderId": "101",
  "product": "iPhone",
  "quantity": 2,
  "eventType": "ORDER_CREATED"
}
```

---

## Running Kafka

Start Kafka and Zookeeper using Docker:

```bash
docker compose up -d
```

Verify:

```bash
docker ps
```

---

## Running the Application

```bash
mvn spring-boot:run
```

or run:

```java
KafkaOrderServiceApplication
```

from IntelliJ.

---

## Testing the API

### Request

```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-d '{"orderId":"101","product":"iPhone","quantity":2}'
```

### Response

```text
Order Event Published Successfully
```

---

## Sample Kafka Flow

### Step 1

Client sends:

```json
{
  "orderId":"101",
  "product":"iPhone",
  "quantity":2
}
```

### Step 2

Controller converts JSON into an OrderEvent object.

### Step 3

Producer publishes the event to Kafka.

### Step 4

Kafka stores the event in the `orders` topic.

### Step 5

Consumer receives and processes the event.

---

## Key Concepts Learned

* Event-Driven Architecture
* Producer-Consumer Pattern
* Asynchronous Communication
* Kafka Topics
* Consumer Groups
* Spring Dependency Injection
* REST APIs with Spring Boot

---

## Future Improvements

* Add PostgreSQL persistence
* Add multiple consumer groups
* Add retry and dead-letter queue handling
* Add inventory and analytics services
* Extend to a vehicle tracking pipeline similar to production data systems

---

Built as a hands-on learning project to understand Apache Kafka and distributed event processing.
