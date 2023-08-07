package com.example.blogapp.security;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtServiceTest {
  private JwtService jwtService() {
    return new JwtService();
  }

  @Test
  public void createJwt_with_username() {
    JwtService jwtService = jwtService();
    String testUsername = "shubham";
    String jwtToken = jwtService.createJwt(testUsername);
    String username = jwtService.getUsernameFromJwt(jwtToken);
    assertEquals(testUsername, username);
  }

  @Test
  public void createJwt_error_with_null() {
    JwtService jwtService = jwtService();
    assertThrows(IllegalArgumentException.class, () -> {
      String jwtString = jwtService.createJwt(null);
    });
  }
}