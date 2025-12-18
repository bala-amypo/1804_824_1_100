package com.example.demo.controller;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")

public class UserController
{
    @Autowired
    UserService obj;
    
    @PostMapping("/register")
    public User UserRegister(@RequestBody User user)
    {
        return obj.register(user);
    }


    
}