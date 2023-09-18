package com.example.microservicesproject.microservices;

import com.example.microservicesproject.objects.product;
import com.example.microservicesproject.services.productService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Path("/products")
public class productManager {

//        @GET
//        @Path("")
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)

        @Autowired
        private final productService productService;

        public productManager(com.example.microservicesproject.services.productService productService) {
            this.productService = productService;
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<product> getProduct() {
            return productService.findAllProducts();
        }

        @POST
        @Path("/newProduct")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response saveProduct(product product){
            try {
                productService.saveAnProduct(product);
                return Response.status(Response.Status.OK).entity(product).build();
            } catch (Exception e) {
                // here, there will be logging, hopefully, somewhere, at some point in time
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Failed to save product due to an internal error.")
                        .build();
            }

        }
        @POST
        @Path("/update")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response updateProduct(product product){
            try {
                productService.saveAnProduct(product);
                return Response.status(Response.Status.OK).entity(product).build();
            } catch (Exception e) {
                // here, there will be logging, hopefully, somewhere, at some point in time
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Failed to update product due to an internal error.")
                        .build();
            }
        }
        @DELETE
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response deleteProduct(product product){
            try {
                productService.delete(product.getId());
                return Response.status(Response.Status.OK).entity(product).build();
            } catch (Exception e) {
                // here, there will be logging, hopefully, somewhere, at some point in time
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Failed to delete product due to an internal error.")
                        .build();
            }
        }
        @GET
        @Path("/findById")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public product getProductById(int id){
            return productService.findById(id);
        }

}
