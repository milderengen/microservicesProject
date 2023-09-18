package com.example.microservicesproject.microservices.consumers;

import com.example.microservicesproject.generalFunctions;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


public class storageManagerConsumer {
    @Autowired
    private final generalFunctions generalFunctions;
    @Autowired
    private final  orderService orderService;
    @Autowired
    private final com.example.microservicesproject.SQL.productSQL productSQL;
    public storageManagerConsumer(com.example.microservicesproject.SQL.productSQL productSQL, com.example.microservicesproject.generalFunctions generalFunctions, com.example.microservicesproject.services.orderService orderService) {
        this.productSQL = productSQL;
        this.generalFunctions = generalFunctions;
        this.orderService = orderService;
    }


    @KafkaListener(topics = "orders-topic")
    public void listen(order order) {
        switch(order.getOrderType()){
            case CREATE, UPDATE -> {
                    generalFunctions.createOrUpdate(order,productSQL);
            }
            case DELETE -> orderService.delete(order.getOrderID());
        }


    }
}
