package com.example.blogapp.users;

import com.example.blogapp.users.dtos.CreateUserDto;
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
}
