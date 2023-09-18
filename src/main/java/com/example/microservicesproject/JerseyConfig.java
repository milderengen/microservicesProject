package com.example.microservicesproject;
import com.example.microservicesproject.microservices.productManager;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
@Component
public class JerseyConfig extends ResourceConfig{



        public JerseyConfig() {
            register(productManager.class);
        }

}
