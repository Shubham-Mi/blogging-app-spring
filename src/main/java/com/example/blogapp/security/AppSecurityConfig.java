package com.example.blogapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().disable().csrf().disable()
      .authorizeHttpRequests(authz -> authz
        .requestMatchers(HttpMethod.GET, "/about").permitAll()
        .requestMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
        .anyRequest().authenticated()
      );
    return http.build();
  }
}
