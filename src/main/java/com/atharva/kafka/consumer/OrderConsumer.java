package com.atharva.kafka.consumer;

import com.atharva.kafka.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "orders",
            groupId = "order-group"
    )
    public void consume(OrderEvent orderEvent) {

        System.out.println("Event Consumed -> " + orderEvent);

        System.out.println(
                "Inventory updated for orderId: " + orderEvent.getOrderId()
        );
    }
}