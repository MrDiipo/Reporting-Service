package com.mintyn.reportingservice.service;

import com.mintyn.reportingservice.domain.Order;

public interface KafkaConsumerService {
    void listenForOrder(Order order);

    Order getOrder();
}
