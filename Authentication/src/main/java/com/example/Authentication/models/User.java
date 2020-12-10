package com.example.Authentication.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "uniqueNameConstraint")
})
//todo: throw error for duplicate emails

public class User {

  @Column(name = "email", unique = true)//todo not working
  private  String email;

  @Column(name = "password")
  private String password;//todo hash it with jwt and bcrypt

  @Id
  @GeneratedValue
  private UUID id;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User() {
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

  public void hashPassword(String newPassword){
    password = newPassword;
  }

  public UUID getId() {
    return id;
  }


}
