package com.example.Authentication.services;

import com.example.Authentication.models.User;
import com.example.Authentication.repositories.userRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class userService {

  @Autowired
  private userRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }

  public void createUser(User user){
    repository.save(user);
  }

  public User findById(UUID id){
    return repository.findById(id).orElse(null);
  }

  public void deleteById(UUID id){
    repository.deleteById(id);
  }

  //todo: remove method before going live
  public void deleteAll(){
    repository.deleteAll();
  }

}
