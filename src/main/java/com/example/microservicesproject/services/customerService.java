package com.example.microservicesproject.services;

import com.example.microservicesproject.SQL.customerSQL;
import com.example.microservicesproject.objects.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {
    @Autowired
    private customerSQL customerSQL;

    public Customer getCustomerById(int id){ //is present check
        return customerSQL.findById(id).get();
    }
    public void save(Customer customer){
        customerSQL.save(customer);
    }
    public List<Customer> findAll(){
        return customerSQL.findAll();
    }

}
