package com.example.demo.models;

public class LoginRequest {
  private String username;
  private String password;

  public LoginRequest() {
  }

  public LoginRequest(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
