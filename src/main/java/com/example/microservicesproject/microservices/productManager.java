package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.product;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("/products")
public class productManager {
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public product getProduct() {
            return new Product(1L, "Sample Product", 29.99);
        }

}
