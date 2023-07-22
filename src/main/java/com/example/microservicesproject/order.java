package com.example.microservicesproject;

import java.util.List;

public class order {
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
