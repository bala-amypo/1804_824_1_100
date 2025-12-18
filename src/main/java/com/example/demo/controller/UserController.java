package com.example.demo.controller;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.bins.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/auth")

public class UserController
{
    @Autowired
    UserService obj;
    
    @PostMapping("/register")
    public User UserRegister(User user)
    {
        return obj.register(user);
    }


    
}