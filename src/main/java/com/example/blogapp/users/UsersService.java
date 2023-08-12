package com.example.blogapp.users;

import com.example.blogapp.security.JwtService;
import com.example.blogapp.users.dtos.CreateUserDto;
import com.example.blogapp.users.dtos.LoginUserDto;
import com.example.blogapp.users.dtos.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  private final UsersRepository usersRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public UsersService(
      UsersRepository usersRepository,
      ModelMapper modelMapper,
      PasswordEncoder passwordEncoder,
      JwtService jwtService) {
    this.usersRepository = usersRepository;
    this.modelMapper = modelMapper;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
  }

  public UserResponseDto creteUser(CreateUserDto user) {
    UserEntity newUser = modelMapper.map(user, UserEntity.class);
    newUser.setPassword(passwordEncoder.encode(user.getPassword()));
    UserEntity savedUser = usersRepository.save(newUser);
    UserResponseDto response = modelMapper.map(savedUser, UserResponseDto.class);
    response.setToken(jwtService.createJwt(newUser.getUsername()));
    return response;
  }

  public UserResponseDto verifyUser(LoginUserDto request) {
    UserEntity user = usersRepository.findByUsername(request.getUsername());

    if (user == null) {
      throw new RuntimeException(("User not found"));
    }
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid credentials");
    }
    return modelMapper.map(user, UserResponseDto.class);
  }

  public UserResponseDto findUserByUsername(String username) {
    UserEntity user = usersRepository.findByUsername(username);
    return modelMapper.map(user, UserResponseDto.class);
  }
}
