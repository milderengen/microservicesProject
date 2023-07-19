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

    }
    public List<LineProduct> rapidFire(){

    }
}
