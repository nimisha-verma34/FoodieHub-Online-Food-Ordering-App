package com.food.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.entity.Restaurants;

public interface RestaurantRepo extends JpaRepository<Restaurants, Integer>
{
    List<Restaurants> findByNameContainingIgnoreCase(String keyword);
}
