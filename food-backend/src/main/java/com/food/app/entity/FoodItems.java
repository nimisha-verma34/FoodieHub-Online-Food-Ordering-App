package com.food.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "food_items")
public class FoodItems 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurants restaurant;

 
    public Long getId(){ return id; }
    public String getName(){ return name; }
    public int getPrice(){ return price; }
    public String getDescription(){ return description; }
    public String getImgUrl(){ return imgUrl; }
    public Restaurants getRestaurant(){ return restaurant; }
}
