package com.example.microservicesproject.services;
import com.example.microservicesproject.SQL.productSQL;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.objects.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {
    private final productSQL productSQL;

    @Autowired
    public productService(com.example.microservicesproject.SQL.productSQL productSQL) {
        this.productSQL = productSQL;
    }

    public List<product> findAllProducts(){
        return productSQL.findAll();
    }
    public Optional<product> findByProductName(String productName){
        return productSQL.findByProductName(productName);
    }
    public product findById(int id){
        if(productSQL.findById(id).isPresent()){
            return productSQL.findById(id).get();
        }
        return null;
    }
    public void saveAnProduct(product product){
        productSQL.save(product);
    }
    public void delete(int id){
        if(productSQL.findById(id).isPresent()){
            productSQL.delete(productSQL.findById(id).get());
        }
    }
}
