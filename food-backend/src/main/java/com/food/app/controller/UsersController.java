package com.food.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.service.UsersService;

import jakarta.validation.Valid;

import com.food.app.dto.LoginRequest;
import com.food.app.entity.Users;


@RestController
@RequestMapping("/users")
public class UsersController 
{
    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public Users registerUser(@Valid @RequestBody Users user)
    {
        return usersService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUsers(@RequestBody LoginRequest loginRequest) {
        return usersService.loginUser(
            loginRequest.getEmail(),
            loginRequest.getPassword()
        );
    }
    

}

