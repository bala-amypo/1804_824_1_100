package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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