package com.example.Authentication.controllers;

import com.example.Authentication.models.User;
import com.example.Authentication.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class userController {

//  @Autowired
//  private User user;

  @Autowired
  private userService service;

  @PostMapping
  public User createUser(@RequestParam String email, @RequestParam String password){
    User user = new User(email, password, new UUID(1,1));
    service.createUser(user);
    return user;
  }

  @GetMapping
  public List<User> getAllUsers(){

    return service.findAll();
  }

}
