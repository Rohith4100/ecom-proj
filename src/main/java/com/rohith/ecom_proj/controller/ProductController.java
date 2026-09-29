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
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Optional<Product> product = service.getProductById(prodId);
        return product
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        Product p=service.addProduct(product);
        return new ResponseEntity<>(p,HttpStatus.CREATED);

    }

    @PutMapping("/product/{prodId}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int prodId,
            @RequestBody Product product) {

        try {
            Product updated = service.updateProduct(prodId, product);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{prodId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int prodId) {
        try {
            service.deleteProduct(prodId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
