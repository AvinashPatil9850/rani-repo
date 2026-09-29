package com.example.crud.controller;

import com.example.crud.entity.Customer;
import com.example.crud.entity.User;
import com.example.crud.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
      User userInDb = userService.findByUserName(user.getUsername());
      if(userInDb != null){
          userInDb.setUsername(user.getUsername());
          userInDb.setPassword((user.getPassword()));
          userService.saveUser((userInDb));
      }
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }
