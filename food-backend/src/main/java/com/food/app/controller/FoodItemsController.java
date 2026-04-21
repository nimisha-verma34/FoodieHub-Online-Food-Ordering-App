package com.food.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.food.app.service.FoodItemsService;
import com.food.app.entity.FoodItems;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:5173")

public class FoodItemsController 
{
    @Autowired
    private FoodItemsService foodItemsService;

    @GetMapping("/{restaurantId}/items")
    public List<FoodItems> getFoodItems(@PathVariable int restaurantId)
    {
        return foodItemsService.getFoodItem(restaurantId);
    }
}
