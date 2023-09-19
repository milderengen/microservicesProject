package com.example.microservicesproject.objects;

import com.example.microservicesproject.objects.product;
import jakarta.persistence.*;

public class LineProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JoinColumn(name = "id")
    product product;


    @Column(name = "quantity")
    int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    order order;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public com.example.microservicesproject.objects.order getOrder() {
        return order;
    }

    public void setOrder(com.example.microservicesproject.objects.order order) {
        this.order = order;
    }

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
