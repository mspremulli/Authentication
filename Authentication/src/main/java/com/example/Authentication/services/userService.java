package com.example.Authentication.services;

import com.example.Authentication.models.User;
import com.example.Authentication.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {

  @Autowired
  userRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }


}
