package com.food.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.entity.Restaurants;
import com.food.app.repository.*;

@Service
public class RestService 
{
    @Autowired
    private RestaurantRepo restaurantRepo;


    public List<Restaurants> getAllRestaurants()
    {
       return restaurantRepo.findAll();
    }

    public List<Restaurants> getRestaurantByName(String keyword)
    {
        return restaurantRepo.findByNameContainingIgnoreCase(keyword);
    }

}
