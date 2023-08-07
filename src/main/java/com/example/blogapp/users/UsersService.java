package com.example.blogapp.users;

import com.example.blogapp.users.dtos.CreateUserDto;
import com.example.blogapp.users.dtos.LoginUserDto;
import com.example.blogapp.users.dtos.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponseDto creteUser(CreateUserDto user) {
        UserEntity newUser = modelMapper.map(user, UserEntity.class);
        UserEntity savedUser = usersRepository.save(newUser);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public UserResponseDto verifyUser(LoginUserDto request) {
        UserEntity user = usersRepository.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException(("User not found"));
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return modelMapper.map(user, UserResponseDto.class);
    }
    public UserResponseDto findUserByUsername(String username) {
        UserEntity user = usersRepository.findByUsername(username);
        return modelMapper.map(user, UserResponseDto.class);
    }
}
