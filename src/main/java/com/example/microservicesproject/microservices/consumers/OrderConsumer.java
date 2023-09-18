package com.example.microservicesproject.microservices.consumers;

import com.example.microservicesproject.objects.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private final com.example.microservicesproject.SQL.orderSQL orderSQL;
    public OrderConsumer(com.example.microservicesproject.SQL.orderSQL orderSQL) {
        this.orderSQL = orderSQL;
    }


    @KafkaListener(topics = "orders-topic")
    public void listen(order order) {
        orderSQL.save(order);
    }

    
}
