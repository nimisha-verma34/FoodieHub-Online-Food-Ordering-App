package com.food.app.controller;

import com.food.app.entity.Cart;
import com.food.app.dto.CartItemRequest;
import com.food.app.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) 
    {
    return cartService.getCartByUserId(userId);
    }

    
    @PostMapping("/{userId}/add")
    public Cart addToCart(@PathVariable int userId, @RequestBody CartItemRequest request)
    {
        return cartService.addToCart
        (
                userId,
                request.getFoodItemId(),
                request.getQuantity(),
                request.getPrice()
        );
    }
}
