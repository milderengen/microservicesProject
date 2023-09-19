package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.services.orderService;

import java.util.Random;

public class paymentManager {
    private orderService orderService;

    public void paySomeoneTheirOrder(){
        Random random = new Random();
        int randomNumber = random.nextInt(orderService.findAllOrders().size()-1);
        orderService.findById(randomNumber).setPaid(true);
        orderService.saveAnOrder(orderService.findById(randomNumber));
    }
    public boolean paidNotPaid(order order){
        return orderService.findById(order.getOrderID()).isPaid();
    }
}
