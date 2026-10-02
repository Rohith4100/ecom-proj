package com.rohith.ecom_proj.repo;

import com.rohith.ecom_proj.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Integer> {
}
