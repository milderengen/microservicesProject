package com.example.microservicesproject;

import com.example.microservicesproject.objects.Customer;
import com.example.microservicesproject.objects.LineProduct;
import com.example.microservicesproject.objects.order;
import com.example.microservicesproject.objects.product;
import com.example.microservicesproject.services.customerService;
import com.example.microservicesproject.services.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class generalFunctions {
    @Autowired
    private customerService customerService;
    Random random = new Random();
    public order dummyOrder(){
        double randy = Math.random() * (10);
        int rand = (int) randy;
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
            lineProduct.setOrder(order);
            order.addProduct(lineProduct);
        }
        order.setCostumer(customerService.getCustomerById(rand));
        order.setCreatedAt(new Date());
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
    public int checkFile(MultipartFile file){
        final long MAX_SIZE = 1024 * 1024 * 5; // 5 MB
        if (file.isEmpty()) {
            return 1;
        }

        // Check the file type
        String contentType = file.getContentType();
        if (!isAllowedContentType(contentType)) {
            return 2;
        }

        // Check the file size
        long size = file.getSize();
        if (size > MAX_SIZE) {
            return 3;
        }
        return 0;
    }
    private boolean isAllowedContentType(String contentType) {
        // Define allowed content types and check
        return "image/jpeg".equals(contentType) || "image/png".equals(contentType);
    }

    public String generateSafeFileName(String originalFileName) {
        // Generate a safe file name, could use UUIDs
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }
}
