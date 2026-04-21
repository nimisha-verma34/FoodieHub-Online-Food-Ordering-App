package com.food.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.food.app.entity.FoodItems;

public interface FoodItemsRepo extends JpaRepository<FoodItems, Long> 
{
    List<FoodItems> findByRestaurantId(int restaurantId);
}
