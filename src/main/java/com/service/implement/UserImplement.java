package com.example.demo.service.implement;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserImplement implements UserService{
    @Autowired
    UserRepository obj;
    public User register(User user){
        return obj.save(user);
    }
    public String findByEmail(String email){
        return obj.findById(email);
    }
    public String getUser(Long id)
    {
        return obj.findById(id);
    }

}