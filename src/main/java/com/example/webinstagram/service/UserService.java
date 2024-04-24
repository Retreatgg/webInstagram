package com.example.webinstagram.service;

import com.example.webinstagram.dto.UserCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerUser(UserCreateDto user);
}
