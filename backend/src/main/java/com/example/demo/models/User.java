package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.demo.enums.ERole;

@Entity
@Table(name = "user")
public class User {
  @Id
  @Column(name = "userId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String username;
  private String password;
  @Enumerated(EnumType.STRING)
  private ERole role;

  public User(long userId, String username, String password, String role) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.role = ERole.valueOf(role);
  }

  public User() {

  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return this.role.getAuthority();
  }

  public void setRole(final String role) {
    this.role = ERole.valueOf(role);
  }
}

