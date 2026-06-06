package com.atharva.kafka.producer;

import com.atharva.kafka.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private static final String TOPIC = "orders";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendOrderEvent(OrderEvent orderEvent) {

        kafkaTemplate.send(
                TOPIC,
                orderEvent.getOrderId(),
                orderEvent
        );

        System.out.println(
                "Event Published -> " + orderEvent
        );
    }
}