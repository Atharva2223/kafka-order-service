package com.atharva.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class OrderEvent {

    private String orderId;
    private String product;
    private int quantity;
    private String eventType;
}
