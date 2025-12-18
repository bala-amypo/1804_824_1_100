package com.example.demo.service;
import com.example.demo.model.User;

public interface UserService{
    User register(User user);
    String  findByEmail(String email );
    Long getUser(Long id);
}