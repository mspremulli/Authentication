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
    hashPassword(user);
    service.createUser(user);
    return user;
  }

  private void hashPassword(User user){
    user.hashPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
  }

  @PutMapping
  public String signIn(@RequestBody User user){
    try{
      User checkUser = service.findUserByEmail(user.getEmail());
      if(checkUser == null) return "user not found";

      String hashedPassword = checkUser.getPassword();

      if(BCrypt.checkpw(user.getPassword(), hashedPassword)){
        Instant currentTime = Instant.now();
        Date signedAt = Date.from(currentTime);
        Date expiresAt = Date.from(currentTime.plus(8, ChronoUnit.HOURS));

        SecretKey key = Keys.hmacShaKeyFor(env.getProperty("JWTKey").getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder()
                .setSubject("user-auth")
                .setIssuedAt(signedAt)
                .setExpiration(expiresAt)
                .claim("id", checkUser.getId())
                .signWith(key)
                .compact();

        return jwt;
      }
      else{
        return "login failed: username and password do not match";
      }

    }
    catch (Exception e) {
      e.printStackTrace();
      return e.getMessage();
    }

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
