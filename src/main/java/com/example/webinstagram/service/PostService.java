package com.example.webinstagram.service;


import com.example.webinstagram.dto.PostCreateDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    void createPost(Authentication authentication,  PostCreateDto postCreateDto);
}
