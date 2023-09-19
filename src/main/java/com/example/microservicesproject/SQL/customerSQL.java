package com.example.microservicesproject.SQL;

import com.example.microservicesproject.objects.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerSQL extends JpaRepository<Customer,Integer> {
}
