package com.food.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.app.repository.UsersRepo;
import com.food.app.entity.Users;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Users registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public String loginUser(String email, String rawPassword) {

        Optional<Users> userOpt = usersRepo.findByEmail(email);
    
        if (userOpt.isEmpty()) {
            return "User not found, try registering?";
        }
    
        Users user = userOpt.get();
    
        if (!encoder.matches(rawPassword, user.getPassword())) {
            return "Invalid password, try again!";
        }
    
        return "Welcome " + user.getUsername();
    }
    
}
