package com.food.app.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name="username")
    private String username;

    @NotBlank
    @Column(name="password")
    private String password;

    @Email
    @NotBlank
    @Column(name="email")
    private String email;

    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public String getEmail(){return email;}

    public void setUsername(String username){this.username=username;}
    public void setPassword(String password){this.password=password;}
    public void setEmail(String email){this.email=email;}
}
