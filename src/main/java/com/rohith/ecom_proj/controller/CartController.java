package com.rohith.ecom_proj.controller;

import com.rohith.ecom_proj.model.Cart;
import com.rohith.ecom_proj.model.CartItem;
import com.rohith.ecom_proj.repo.CartItemRepo;
import com.rohith.ecom_proj.service.CartService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(){
        return ResponseEntity.ok(cartService.createCart());
    }

    @GetMapping("{cartId}")
    public ResponseEntity<Cart>  getCart(@PathVariable int cartId){
        return ResponseEntity.ok(cartService.getCart(cartId));
    }

    @PostMapping("{cartId}/items")
    public ResponseEntity<CartItem> addProductToCart(@PathVariable int cartId, @RequestParam int prodId, @RequestParam int quantity){
        return ResponseEntity.ok(cartService.addItemToCart(cartId, prodId, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{cartId}/items/{prodId}")
    public ResponseEntity<CartItem> updateCart(@PathVariable int cartId, @PathVariable int prodId, @RequestParam int quantity){
        return ResponseEntity.ok(cartService.updateItemQuantity(cartId, prodId, quantity));
    }

    @DeleteMapping("/{cartId}/items/{prodId}")
    public ResponseEntity<Void> deleteCart(@PathVariable int cartId, @PathVariable int prodId){
        cartService.deleteCartItem(cartId,prodId);
        return ResponseEntity.noContent().build();
    }
}
