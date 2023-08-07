package com.example.blogapp.security;

import com.example.blogapp.users.UsersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  public AppSecurityConfig(JwtService jwtService, UsersService usersService) {
    jwtAuthenticationFilter = new JwtAuthenticationFilter(
      new JwtAuthenticationManager(
        jwtService,
        usersService
      )
    );
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().disable().csrf().disable()
      .authorizeHttpRequests(authz -> authz
        .requestMatchers(HttpMethod.GET, "/about").permitAll()
        .requestMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
        .anyRequest().authenticated()
      )
      .addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class)
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }
}
