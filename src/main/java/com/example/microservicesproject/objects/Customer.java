package com.example.microservicesproject.objects;

import jakarta.persistence.*;

import java.util.Date;

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CustomerID;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "upToDate")
    boolean upToDate;

    public boolean isUpToDate() {
        return upToDate;
    }

    public void setUpToDate(boolean upToDate) {
        this.upToDate = upToDate;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "updatedAt")
    Date updatedAt;


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
