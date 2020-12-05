package com.example.Authentication.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
  private String email;
  private String password;//todo hash it with jwt and bcrypt
  @Id
  private UUID id;

  public User(){

  }

  public User(String userName, String password, UUID id) {
    this.email = userName;
    this.password = password;
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

}
