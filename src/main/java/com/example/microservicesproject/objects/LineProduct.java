package com.example.microservicesproject.objects;

import com.example.microservicesproject.objects.product;

public class LineProduct {
    product product;
    int quantity;

    public com.example.microservicesproject.objects.product getProduct() {
        return product;
    }

    public void setProduct(com.example.microservicesproject.objects.product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
