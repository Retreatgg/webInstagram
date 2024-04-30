package com.example.webinstagram.service;

import com.example.webinstagram.dto.UserCreateDto;
import com.example.webinstagram.dto.UserDto;
import com.example.webinstagram.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserCreateDto user);
    UserDto getUserByEmail(String email);

    ResponseEntity<?> downloadImage(String email);
    UserDto getUserById(Long id);

    void update(User user);

}
