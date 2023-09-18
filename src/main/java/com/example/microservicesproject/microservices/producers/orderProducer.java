package com.example.microservicesproject.microservices.producers;

import com.example.microservicesproject.generalFunctions;
import com.example.microservicesproject.microservices.OrderManager;
import com.example.microservicesproject.objects.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class orderProducer {
    private final KafkaTemplate<String, order> kafkaTemplate;
    com.example.microservicesproject.generalFunctions generalFunctions = new generalFunctions();
    @Autowired
    private com.example.microservicesproject.orderService orderService;
    @Autowired
    private OrderManager orderManager;

    @Autowired
    public orderProducer(KafkaTemplate<String, order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String topic, order message){
        kafkaTemplate.send(topic, message);
    }
    public void rapidOrderSend(){
        int counter = 0;
        for(int i = 0;i<5;i++){
            if(counter>15){i=6;}
            order order = generalFunctions.dummyOrder();
            if(orderManager.canBeDone(order)){
                sendOrder("topic", order);
            }else{
                i = i-1;
                counter++;
            }
        }
    }
}
