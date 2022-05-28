package com.example.demo.security;

import com.example.demo.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
  private User user;
  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(final User user, final Collection<? extends GrantedAuthority> authorities) {
    this.user = user;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public static UserDetailsImpl build(final User user) {
    GrantedAuthority authorities = new SimpleGrantedAuthority(user.getRole());
    return new UserDetailsImpl(
        user,
        (Collection<? extends GrantedAuthority>) authorities);
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public long getUserId() {
    return this.user.getUserId();
  }

}
