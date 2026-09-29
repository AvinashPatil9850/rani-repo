package com.example.crud.serivce;

import com.example.crud.entity.Customer;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }


    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUsername(userName).orElse(null);
    }
}
