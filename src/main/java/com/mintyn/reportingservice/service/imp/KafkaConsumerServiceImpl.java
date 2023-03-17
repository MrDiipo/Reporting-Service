package com.mintyn.reportingservice.service.imp;

import com.mintyn.reportingservice.domain.Order;
import com.mintyn.reportingservice.service.KafkaConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final String SALES_TOPIC = "sales-topic";

    private Order order;

    @Override
    @KafkaListener(topics = SALES_TOPIC)
    public void listenForOrder(Order order) {
       this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
