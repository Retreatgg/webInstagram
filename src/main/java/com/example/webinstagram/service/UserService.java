package com.example.webinstagram.service;

import com.example.webinstagram.dto.UserCreateDto;
import com.example.webinstagram.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserCreateDto user);
    UserDto getUserByEmail(String email);
}
