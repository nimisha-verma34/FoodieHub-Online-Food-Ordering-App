package com.food.app.dto;

public class CartItemRequest {
    private Long foodItemId;
    private int quantity;
    private Double price;

    
    public Long getFoodItemId(){return foodItemId;}
    public int getQuantity(){return quantity;}
    public Double getPrice(){return price;}

    public void setFoodItemId(Long foodItemId){this.foodItemId=foodItemId;}
    public void setQuantity(int quantity){this.quantity=quantity;}
    public void setPrice(Double price){this.price=price;}
}
