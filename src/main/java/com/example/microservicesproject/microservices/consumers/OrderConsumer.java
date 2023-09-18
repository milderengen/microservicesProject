package com.example.microservicesproject.microservices.consumers;

import com.example.microservicesproject.microservices.OrderManager;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private orderService orderService;
    @Autowired
    private OrderManager orderManager;



    @KafkaListener(topics = "orders-topic")
    public void listen(order order) {

            orderService.saveAnOrder(order);


    }

    
}
