package com.example.microservicesproject.services;

import com.example.microservicesproject.SQL.notificationSQL;
import com.example.microservicesproject.objects.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notificationService {
    @Autowired
    private notificationSQL notificationSQL;
    public void save(Notification notification){
        notificationSQL.save(notification);
    }
    public void delete(Notification notification){
        notificationSQL.delete(notification);
    }
}
