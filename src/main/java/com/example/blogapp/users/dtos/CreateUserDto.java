package com.example.blogapp.users.dtos;

import lombok.Data;

@Data
public class CreateUserDto {

  private String username;
  private String email;
  private String password;
}
