package com.food.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.food.app.repository.FoodItemsRepo;
import com.food.app.entity.FoodItems;

import java.util.List;

@Service
public class FoodItemsService 
{
    @Autowired
    private FoodItemsRepo foodItemsRepo;

    public List<FoodItems> getFoodItem( int restaurantId)
    {
        return foodItemsRepo.findByRestaurantId(restaurantId);
    }
    
}
