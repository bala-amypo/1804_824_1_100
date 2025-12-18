package com.example.demo.service.implement;
import com.example.demo.service.
public class UserImplement implements UserService{
    @AutoWired
    UserRepository obj;
    User register(User user){
        return obj.save(user);
    }
    String findByEmail(String email){
        return obj.getById(email);
    }
    String getUser(Long id)
    {
        return obj.getById(id);
    }

}