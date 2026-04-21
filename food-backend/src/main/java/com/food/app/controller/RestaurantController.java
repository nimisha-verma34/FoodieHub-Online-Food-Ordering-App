package com.food.app.controller;

import com.food.app.entity.Restaurants;
import com.food.app.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantController {

    @Autowired
    private RestService restService;

    @GetMapping("/all")
    public List<Restaurants> getAllRestaurants() {
        return restService.getAllRestaurants();
    }

    @GetMapping("/search")
    public List<Restaurants> searchRestaurants(@RequestParam String keyword)
    {
        return restService.getRestaurantByName(keyword);
    }
}
