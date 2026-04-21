package com.food.app.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="restaurants")
public class Restaurants 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    @Column(name="img_url")
    private String imgUrl;

    private double rating;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FoodItems> foodItems;


    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getAddress(){ return address; }
    public String getImgUrl(){ return imgUrl; }
    public double getRating(){ return rating; }
    public List<FoodItems> getFoodItems(){ return foodItems; }
}
