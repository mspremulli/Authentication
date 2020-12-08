package com.example.Authentication.controllers;

import com.example.Authentication.models.User;
import com.example.Authentication.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public Object getUsers(@RequestHeader(required = false) UUID id){
    if(id != null) return service.findById(id);
    return service.findAll();
  }

  @DeleteMapping
  public void deleteUserById(@RequestHeader(required = false) UUID id){
    if(id != null) service.deleteById(id);
//    else service.deleteAll();
  }

}
