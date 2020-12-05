package com.example.Authentication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
  private String email;
  private String password;//todo hash it with jwt and bcrypt

  @Id
  @GeneratedValue
  private UUID id;

  public User(){

  }

  public User(String email, String password, UUID id) {
    this.email = email;
    this.password = password;
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public UUID getId() {
    return id;
  }
}
