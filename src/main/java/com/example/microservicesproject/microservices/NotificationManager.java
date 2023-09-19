package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.Notification;
import com.example.microservicesproject.services.notificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    @Autowired
    private notificationService notificationService;
    public void SendNotification(Notification notification){
        notificationService.save(notification);
    }
}
