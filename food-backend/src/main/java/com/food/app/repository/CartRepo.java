package com.food.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>
{
    Optional<Cart> findByUserId(int userId);
}
