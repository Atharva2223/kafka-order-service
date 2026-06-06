package com.atharva.kafka.controller;

import com.atharva.kafka.model.OrderEvent;
import com.atharva.kafka.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String createOrder(
            @RequestBody OrderEvent orderEvent
    ) {

        orderEvent.setEventType(
                "ORDER_CREATED"
        );

        orderProducer.sendOrderEvent(
                orderEvent
        );

        return "Order Event Published";
    }
}