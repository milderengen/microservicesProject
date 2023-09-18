package com.example.microservicesproject.SQL;

import com.example.microservicesproject.objects.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface productSQL extends JpaRepository<product, Integer> {
    Optional<product> findByProductName(String productName);
}
