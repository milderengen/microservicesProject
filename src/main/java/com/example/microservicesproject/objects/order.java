package com.example.microservicesproject.objects;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class order {
//    public com.example.microservicesproject.orderType getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(com.example.microservicesproject.orderType orderType) {
//        this.orderType = orderType;
//    }

    public Customer getCostumer() {
        return Customer;
    }

    public void setCostumer(Customer costumer) {
        Customer = costumer;
    }
    /*@Column(name = "orderType")
    orderType orderType;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderID;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LineProduct> products;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    Customer Customer;
    @Column(name = "cancelled")
    boolean canceled;
    @Column(name = "updatedAt")
    Date updatedAt;
    @Column(name = "isUpToDate")
    boolean isUpToDate;
    @Column(name = "createdAt")
    Date createdAt;
    @Column(name = "price")
    long price;
    @Column(name = "paid")
    boolean isPaid = true;
    @Column(name = "address")
    String Address;
    @Column(name = "city")
    String city;
    @Column(name = "country")
    String country;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public com.example.microservicesproject.objects.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(com.example.microservicesproject.objects.Customer customer) {
        Customer = customer;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

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
