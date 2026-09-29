package com.rohith.ecom_proj.controller;
import com.rohith.ecom_proj.model.Product;
import com.rohith.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){

        List<Product> product= service.getAllProducts();
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int prodId){
        Optional<Product> product = service.getProductById(prodId);
        if(product.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try{
            Product p=service.addProduct(product);
            return new ResponseEntity<>(p,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
