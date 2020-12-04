package com.example.Authentication.controllers;

import com.example.Authentication.models.User;
import com.example.Authentication.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {

  @Autowired
  userService service;

  @PostMapping
  public User createUser(@RequestParam String email, @RequestParam String password){
    return new User(email, password);
  }

  @GetMapping
  public List<User> getAllUsers(){
    return service.findAll();
  }
}
