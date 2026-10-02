package com.rohith.ecom_proj.service;

import com.rohith.ecom_proj.exception.ResourceNotFoundException;
import com.rohith.ecom_proj.model.Product;
import com.rohith.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Product addProduct(Product product)  {
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        existing.setName(product.getName());
        existing.setDesc(product.getDesc());
        existing.setBrand(product.getBrand());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setAvailable(product.isAvailable());
        existing.setStockQuantity(product.getStockQuantity());

        return repo.save(existing);
    }

    public void deleteProduct(int id) {
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException("Product not found");
        }
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProduct(keyword);
    }
}
