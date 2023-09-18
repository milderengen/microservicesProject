package com.example.microservicesproject.microservices.consumers;

import com.example.microservicesproject.SQL.productSQL;
import com.example.microservicesproject.generalFunctions;
import com.example.microservicesproject.microservices.storageManager;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.services.orderService;
import com.example.microservicesproject.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


public class storageManagerConsumer {
    @Autowired
    private  generalFunctions generalFunctions;
    @Autowired
    private  orderService orderService;
    @Autowired
    private productService productService;
    @Autowired
    private storageManager storageManager;


    @KafkaListener(topics = "orders-topic")
    public void listen(order order) {


        storageManager.saveOrUpdate(order);
    }
}
