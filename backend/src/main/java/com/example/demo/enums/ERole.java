package com.example.demo.enums;

public enum ERole {
  ADMIN("ADMIN"),
  USER("USER");
  private final String name;

  ERole(final String name) {
    this.name = name;
  }

  public String getAuthority() {
    return this.name;
  }
}
