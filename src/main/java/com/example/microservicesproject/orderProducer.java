package com.example.microservicesproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class orderProducer {
    private final KafkaTemplate<String, order> kafkaTemplate;
    generalFunctions generalFunctions = new generalFunctions();

    @Autowired
    public orderProducer(KafkaTemplate<String, order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String topic, order message){
        kafkaTemplate.send(topic, message);
    }
    public void rapidOrderSend(){
        for(int i = 0;i<5;i++){
            sendOrder("topic",generalFunctions.dummyOrder());
        }
    }
}
