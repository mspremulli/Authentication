package com.example.Authentication.controllers;

import com.example.Authentication.models.User;
import com.example.Authentication.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class userController {

  @Autowired
  private userService service;

  @PostMapping
  public User createUser(@RequestBody User user){
    service.createUser(user);
    return user;
  }

  @GetMapping
  public List<User> getAllUsers(){
    return service.findAll();
  }

  @GetMapping("{id}")
  public User getUserById(@PathVariable UUID id){
    return service.findById(id);
  }

  @DeleteMapping("{id}")
  public void deleteUserById(@PathVariable UUID id){
    service.deleteById(id);
  }

  @DeleteMapping
  public void deleteAll(){
    service.deleteAll();
  }

}
