package com.example.microservicesproject.objects;

import com.example.microservicesproject.orderType;

import java.util.Date;
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
    boolean canceled;
    Date updatedAt;
    boolean isUpToDate;
    Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isUpToDate() {
        return isUpToDate;
    }

    public void setUpToDate(boolean upToDate) {
        isUpToDate = upToDate;
    }



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
