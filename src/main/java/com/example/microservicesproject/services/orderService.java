package com.example.microservicesproject.services;

import com.example.microservicesproject.objects.order;
import org.springframework.stereotype.Service;
import com.example.microservicesproject.SQL.*;

import java.util.List;

@Service
public class orderService {
    private final orderSQL orderSQL;

    public orderService(com.example.microservicesproject.SQL.orderSQL orderSQL) {
        this.orderSQL = orderSQL;
    }
    public List<order> findAllOrders(){
        return orderSQL.findAll();
    }
    public order findById(int id){
        if(orderSQL.findById(id).isPresent()){
            return orderSQL.findById(id).get();
        }
        return null;
    }
    public void saveAnOrder(order order){
        orderSQL.save(order);
    }
    public void delete(int id){
        if(orderSQL.findById(id).isPresent()){
            orderSQL.delete(orderSQL.findById(id).get());
        }
    }
}
