package com.rohith.ecom_proj.service;

import com.rohith.ecom_proj.model.Cart;
import com.rohith.ecom_proj.model.CartItem;
import com.rohith.ecom_proj.model.Product;
import com.rohith.ecom_proj.repo.CartItemRepo;
import com.rohith.ecom_proj.repo.CartRepo;
import com.rohith.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private ProductRepo productRepo;

    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepo.save(cart);
    }

    public Cart getCart(int id) {
        return cartRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void deleteCart(int id) {
        if (!cartRepo.existsById(id)) {
            throw new RuntimeException("Cart not found");
        }

        cartRepo.deleteById(id);
    }
    public CartItem addItemToCart(int cartId, int productId, int quantity) {
        if(quantity<0){
            throw new RuntimeException("Quantity should be greater than 0");
        }
        Cart cart = getCart(cartId);
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        if(product.getStockQuantity()<quantity){
            throw new RuntimeException("Insufficient stock quantity");
        }

        Optional<CartItem> existing = cartItemRepo.findByCartIdAndProductId(cartId,productId);
        if(existing.isPresent()){
            CartItem item = existing.get();
            if (item.getQuantity() > product.getStockQuantity()) {
                throw new RuntimeException("Insufficient stock");
            }
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepo.save(item);
            return item;
        }

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartItemRepo.save(cartItem);
    }

    public CartItem updateItemQuantity(
            int cartId,
            int productId,
            int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }
        CartItem item = cartItemRepo
                .findByCartIdAndProductId(cartId, productId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        if (quantity > item.getProduct().getStockQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }
        item.setQuantity(quantity);
        return cartItemRepo.save(item);
    }
    public void deleteCartItem(int cartId,int productId) {
        CartItem item = cartItemRepo.findByCartIdAndProductId(cartId,productId).orElseThrow(()->new RuntimeException("Product not found or Cart not found"));
        cartItemRepo.delete(item);
    }
}