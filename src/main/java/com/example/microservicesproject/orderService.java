package com.example.microservicesproject;

import com.example.microservicesproject.SQL.orderSQL;
import com.example.microservicesproject.objects.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    private final orderSQL orderSQL;
    @Autowired
    public orderService(com.example.microservicesproject.SQL.orderSQL orderSQL) {
        this.orderSQL = orderSQL;
    }
    public void save(order order){
        orderSQL.save(order);
    }
}
