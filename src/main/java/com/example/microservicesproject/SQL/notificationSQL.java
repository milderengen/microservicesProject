package com.example.microservicesproject.SQL;

import com.example.microservicesproject.objects.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface notificationSQL extends JpaRepository<Notification, Integer> {
}
