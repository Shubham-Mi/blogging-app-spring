package com.example.blogapp.security;

import com.example.blogapp.users.UsersService;
import com.example.blogapp.users.dtos.UserResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationManager implements AuthenticationManager {

  private final JwtService jwtService;
  private final UsersService usersService;

  public JwtAuthenticationManager(JwtService jwtService, UsersService usersService) {
    this.jwtService = jwtService;
    this.usersService = usersService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    if (authentication instanceof JwtAuthentication jwtAuthentication) {
      String jwtString = jwtAuthentication.getCredentials();
      String username = jwtService.getUsernameFromJwt(jwtString);
      UserResponseDto user = usersService.findUserByUsername(username);
      // TODO: crypto failure on jwt verification
      // TODO: check if jwt is expired
      jwtAuthentication.setUser(user);
      return jwtAuthentication;
    }
    return null;
  }
}
