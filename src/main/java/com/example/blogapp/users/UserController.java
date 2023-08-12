package com.example.blogapp.users;

import com.example.blogapp.users.dtos.CreateUserDto;
import com.example.blogapp.users.dtos.LoginUserDto;
import com.example.blogapp.users.dtos.UserResponseDto;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UsersService usersService;

  public UserController(UsersService usersService) {
    this.usersService = usersService;
  }

  @PostMapping("")
  public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserDto user) {
    UserResponseDto newUser = usersService.creteUser(user);
    return ResponseEntity.created(URI.create("/profiles" + newUser.getId())).body(newUser);
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponseDto> loginUser(@RequestBody LoginUserDto user) {
    UserResponseDto verifiedUser = usersService.verifyUser(user);
    return ResponseEntity.ok(verifiedUser);
  }
}
