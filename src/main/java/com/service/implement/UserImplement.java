package com.example.demo.service.implement;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserImplement implements UserService{
    @Autowired
    UserRepository obj;
    public User register(User user){
        return obj.save(user);
    }
    public User findByEmail(User email){
        return obj.findByEmail(email).orElse(null);
    }
    public User getUser(User id)
    {
        return obj.findById(id).orElse(null);
    }

}