package com.example.Authentication.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  private String email;
  private String password;//todo hash it with jwt and bcrypt

  public User(String userName, String password) {
    this.email = userName;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

}
