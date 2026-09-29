package com.rohith.ecom_proj.service;

import com.rohith.ecom_proj.model.Product;
import com.rohith.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Optional<Product> getProductById(int prodId) {
        return repo.findById(prodId);
    }

    public Product addProduct(Product product) throws IOException {
        return repo.save(product);
    }
}
