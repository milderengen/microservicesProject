package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.product;
import com.example.microservicesproject.services.productService;
import com.example.microservicesproject.generalFunctions;
import com.example.microservicesproject.objects.order;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.LinkedList;
import java.util.List;

public class storageManager {

    @Inject
    private generalFunctions generalFunctions;
    @Inject
    private productService productService;

    public Response saveOrUpdate(order order){
        try{
            generalFunctions.createOrUpdate(order,productService);
            return Response.status(Response.Status.OK).entity(order).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to save Order due to an internal error.")
                    .build();
        }
    }
    public List<String> goThroughStorage(){
        List<product> all = productService.findAllProducts();
        List<String> toOrder = new LinkedList<>();
        for (com.example.microservicesproject.objects.product product : all) {
            if (product.getQuantity() < 100 && product.getQuantity() > 10) {
                toOrder.add("Quantity of " + product.getName() + " is getting low, check it");
            } else if (product.getQuantity() < 100 && product.getQuantity() <= 10) {
                toOrder.add("Quantity of " + product.getName() + " is critical, order immediately");
            }
        }
        return toOrder;
    }

    public static class ShipmentManager {
    }
}
