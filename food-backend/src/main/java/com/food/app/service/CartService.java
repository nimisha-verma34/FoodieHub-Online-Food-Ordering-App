package com.food.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.food.app.entity.Cart;
import com.food.app.entity.CartItem;
import com.food.app.entity.FoodItems;
import com.food.app.repository.CartItemRepo;
import com.food.app.repository.CartRepo;
import com.food.app.repository.FoodItemsRepo;

@Service
public class CartService {

    private final CartRepo cartRepo;
    private final CartItemRepo cartItemRepo;
    private final FoodItemsRepo foodItemRepo;

    public CartService(CartRepo cartRepo, CartItemRepo cartItemRepo, FoodItemsRepo foodItemRepo) {
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
        this.foodItemRepo = foodItemRepo;
    }

    public Cart addToCart(int userId, Long foodItemId, int quantity, Double price) {
        Cart cart = cartRepo.findByUserId(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUserId(userId);
            return cartRepo.save(newCart);
        });

    
        FoodItems foodItem = foodItemRepo.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("Food item not found with id " + foodItemId));

       
        Optional<CartItem> existingItemOpt = cartItemRepo.findByCartAndFoodItemId(cart, foodItem.getId());

        if (existingItemOpt.isPresent()) {
           
            CartItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            cartItemRepo.save(existingItem);
            return cart;
        }

       
        CartItem newItem = new CartItem();
        newItem.setCart(cart);
        newItem.setFoodItemId(foodItem.getId());
        newItem.setQuantity(quantity);
        newItem.setPrice(price);

        cart.getItems().add(newItem);
        cartItemRepo.save(newItem);

        return cart;
    }

    public Cart getCartByUserId(int userId) {
        return cartRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user " + userId));
    }
}
