package com.example.microservicesproject.objects;

import com.example.microservicesproject.orderType;

import java.util.List;

public class order {
    public com.example.microservicesproject.orderType getOrderType() {
        return orderType;
    }

    public void setOrderType(com.example.microservicesproject.orderType orderType) {
        this.orderType = orderType;
    }

    public Customer getCostumer() {
        return Costumer;
    }

    public void setCostumer(Customer costumer) {
        Costumer = costumer;
    }

    orderType orderType;
    int orderID;
    List<LineProduct> products;
    Customer Costumer;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List<LineProduct> getProducts() {
        return products;
    }

    public void setProducts(List<LineProduct> products) {
        this.products = products;
    }
    public void addProduct(LineProduct product){this.products.add(product);}
}
