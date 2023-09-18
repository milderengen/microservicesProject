package com.example.microservicesproject.services;
import com.example.microservicesproject.SQL.productSQL;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.objects.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    private final productSQL productSQL;

    @Autowired
    public productService(com.example.microservicesproject.SQL.productSQL productSQL) {
        this.productSQL = productSQL;
    }

    public List<product> findAllOrders(){
        return productSQL.findAll();
    }
    public product findById(int id){
        if(productSQL.findById(id).isPresent()){
            return productSQL.findById(id).get();
        }
        return null;
    }
    public void saveAnOrder(product product){
        productSQL.save(product);
    }
    public void delete(int id){
        if(productSQL.findById(id).isPresent()){
            productSQL.delete(productSQL.findById(id).get());
        }
    }
}
