package com.example.blogapp.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

public class JwtAuthenticationConverter implements AuthenticationConverter {
  @Override
  public Authentication convert(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader != null && !authHeader.isEmpty()) {
      return new JwtAuthentication(authHeader);
    }
    return null;
  }
}
