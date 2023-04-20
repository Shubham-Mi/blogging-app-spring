package com.example.blogapp.users;

import com.example.blogapp.users.dtos.CreateUserDto;
import com.example.blogapp.users.dtos.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
}
