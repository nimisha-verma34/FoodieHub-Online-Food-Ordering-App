package com.food.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  

    @Column(name="food_item_id", nullable = false)
    private Long foodItemId;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price_at_time")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    @JsonIgnore
    private Cart cart;

    // --- GETTERS ---
    public Long getFoodItemId(){ return foodItemId; }
    public int getQuantity(){ return quantity; }
    public Double getPrice(){ return price; }

    // --- SETTERS ---
    public void setFoodItemId(Long fooditemId){ this.foodItemId = fooditemId; }
    public void setQuantity(int quantity){ this.quantity = quantity; }
    public void setPrice(Double price){ this.price = price; }
    public void setCart(Cart cart){ this.cart = cart; }
}
