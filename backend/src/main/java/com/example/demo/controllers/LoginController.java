package com.example.demo.controllers;

import com.example.demo.models.JwtToken;
import com.example.demo.models.LoginRequest;
import com.example.demo.security.JwtUtil;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private LoginService loginService;
  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("")
  public JwtToken login(@RequestBody final LoginRequest loginRequest){
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new RuntimeException();
    }
    final UserDetailsImpl userDetails = (UserDetailsImpl) loginService.loadUserByUsername(loginRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return new JwtToken(jwt);
  }
}
