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
    public User getByEmail(String email){
        return obj.findByEmail(email);
    }

    public User getUser(Long id)
    {
        return obj.findById(id);
    }

}