package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.order;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {
    public boolean canBeDone(order order){
        for(int i =0;i<order.getProducts().size();i++){
            if(order.getProducts().get(i).getQuantity()>order.getProducts().get(i).getProduct().getQuantity()){
                return false;
            }
        }
        return true;
    }
}
