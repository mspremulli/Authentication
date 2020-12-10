package com.example.Authentication.controllers;

import com.example.Authentication.models.User;
import com.example.Authentication.services.userService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@RestController
public class userController {

  @Autowired
  private userService service;

  @Autowired
  Environment env;

  @PostMapping
  public User createUser(@RequestBody User user){
    user.hashPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
    service.createUser(user);
    return user;
  }

  @PutMapping
  public User signIn(@RequestBody User user){
    return null;
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
