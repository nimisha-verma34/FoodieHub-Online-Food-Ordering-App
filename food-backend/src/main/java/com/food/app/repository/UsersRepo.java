package com.food.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.app.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>
{
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
}
