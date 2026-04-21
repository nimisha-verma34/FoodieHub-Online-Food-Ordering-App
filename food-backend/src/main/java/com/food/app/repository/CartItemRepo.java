package com.food.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.food.app.entity.*;


public interface CartItemRepo extends JpaRepository<CartItem, Integer>
{
    Optional<CartItem> findByCartAndFoodItemId(Cart cart, Long fooditemId);
}
