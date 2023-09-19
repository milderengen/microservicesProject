package com.example.microservicesproject.objects;

import com.example.microservicesproject.NotificationType;
import jakarta.persistence.*;

import java.util.Date;

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
    @Column(name = "type")
    NotificationType type;
    @Column(name = "message")
    String message;
    @Column(name = "issued")
    Date issued;

    order order;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public com.example.microservicesproject.objects.order getOrder() {
        return order;
    }

    public void setOrder(com.example.microservicesproject.objects.order order) {
        this.order = order;
    }
}
