package com.example.microservicesproject;

import com.example.microservicesproject.objects.LineProduct;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.objects.product;
import com.example.microservicesproject.services.productService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class generalFunctions {
    Random random = new Random();
    public order dummyOrder(){
        List<String> stringList = Arrays.asList(
                "Sausage",
                "Milk",
                "Cake",
                "Bread",
                "Sugar",
                "Salt",
                "Cucumber",
                "Beer",
                "Vodka",
                "AK-47"
        );
        int randomQuantity = random.nextInt();
        order order = new order();
        for(int i = 0;i<randomQuantity;i++){
            int randomProduct = random.nextInt();
            int randomProductQuantity = random.nextInt();
            product product = new product();
            product.setName(stringList.get(randomProduct));
            LineProduct lineProduct = new LineProduct();
            lineProduct.setProduct(product);
            lineProduct.setQuantity(randomProductQuantity);
            order.addProduct(lineProduct);
        }

        return order;
    }
    public void createOrUpdate(order order, productService productSQL){
        for(int i = 0;i<order.getProducts().size();i++){
            Optional<product> optionalProduct = productSQL.findByProductName(order.getProducts().get(i).getProduct().getName());

            if(optionalProduct.isPresent()) {
                product product = optionalProduct.get();

                // Check if enough stock is available
                if(product.getQuantity() >= order.getProducts().get(i).getProduct().getQuantity()) {
                    // Reduce the stock
                    product.setQuantity(product.getQuantity() - order.getProducts().get(i).getProduct().getQuantity());

                    // Update the product in the database
                    productSQL.saveAnProduct(product);
                } else {
                    // Handle insufficient stock scenario (logging, sending a notification, etc.)
                    System.out.println("Insufficient stock for product: " + order.getProducts().get(i).getProduct().getName());
                }
            } else {
                // Handle scenario where product is not found (logging, sending a notification, etc.)
                System.out.println("Product not found: " + order.getProducts().get(i).getProduct().getName());
            }
        }
    }
}
