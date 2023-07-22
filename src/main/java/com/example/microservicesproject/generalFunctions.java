package com.example.microservicesproject;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
}
