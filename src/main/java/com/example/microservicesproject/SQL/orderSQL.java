package com.example.microservicesproject.SQL;

import com.example.microservicesproject.objects.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderSQL extends JpaRepository<order, Integer> {

}
