package com.example.demo.models;

public class JwtToken {
  private String token;

  public JwtToken(final String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
