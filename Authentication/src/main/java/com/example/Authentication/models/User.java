package com.example.Authentication.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User {

  private final String email;
  private String password;//todo hash it with jwt and bcrypt

  @Id
  @GeneratedValue
  private final UUID id;

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

  public void resetPassword(String newPassword){
    password = newPassword;
  }

  public UUID getId() {
    return id;
  }
}
