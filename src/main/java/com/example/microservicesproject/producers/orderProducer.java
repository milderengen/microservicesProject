package com.example.microservicesproject.producers;

import com.example.microservicesproject.generalFunctions;
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
    public orderProducer(KafkaTemplate<String, order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String topic, order message){
        kafkaTemplate.send(topic, message);
    }
    public void rapidOrderSend(){
        for(int i = 0;i<5;i++){
            order order = generalFunctions.dummyOrder();
            orderService.save(order);
            sendOrder("topic", order);
        }
    }
}
