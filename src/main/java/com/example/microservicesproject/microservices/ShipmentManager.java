package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.Notification;
import com.example.microservicesproject.objects.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.microservicesproject.NotificationType.SHIPMENT;

@Service
public class ShipmentManager {
    @Autowired
    private NotificationManager notificationManager;

    public void shipThatShit(order order){

        if(order.isPaid()){
            Notification notification = new Notification();
            notification.setIssued(new Date());
            notification.setMessage("We are shipping your order " + order.getOrderID() +" to your shipping address, you can expect it in 3-5 business days" );
            notification.setType(SHIPMENT);
            notificationManager.SendNotification(notification);
        }
    }
}
