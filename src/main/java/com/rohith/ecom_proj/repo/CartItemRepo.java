package com.rohith.ecom_proj.repo;

import com.rohith.ecom_proj.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepo extends JpaRepository<CartItem,Integer> {
    public Optional<CartItem> findByCartIdAndProductId(Integer cartId, Integer productId);
}
