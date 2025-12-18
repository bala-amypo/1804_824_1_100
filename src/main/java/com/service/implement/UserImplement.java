package com.example.demo.service.implement;
import com.example.demo.service.UserService;
import org.springframework.bins.factory.annotation.Autowired;

public class UserImplement implements UserService{
    @AutoWired
    UserRepository obj;
    User register(User user){
        return obj.save(user);
    }
    String findByEmail(String email){
        return obj.findById(email);
    }
    String getUser(Long id)
    {
        return obj.getById(id);
    }

}