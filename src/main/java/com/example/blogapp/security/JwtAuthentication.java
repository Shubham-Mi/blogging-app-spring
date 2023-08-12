package com.example.blogapp.security;

import com.example.blogapp.users.dtos.UserResponseDto;
import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthentication implements Authentication {

  private final String jwtString;
  private UserResponseDto user;

  public JwtAuthentication(String jwtString) {
    this.jwtString = jwtString;
  }

  public void setUser(UserResponseDto user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getCredentials() {
    return jwtString;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public UserResponseDto getPrincipal() {
    return user;
  }

  @Override
  public boolean isAuthenticated() {
    return user != null;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

  }

  @Override
  public String getName() {
    return null;
  }
}
