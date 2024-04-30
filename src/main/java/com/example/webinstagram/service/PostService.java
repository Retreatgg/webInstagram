package com.example.webinstagram.service;


import com.example.webinstagram.dto.PostCreateDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.dto.PostMainDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void createPost(Authentication authentication,  PostCreateDto postCreateDto);
    List<PostDto> getPostsByAuthorId(Long id);

    PostDto getPostById(Long id);

    void delete(Authentication auth, Long postId);

    void like(Long id);

    List<PostMainDto> getPostsBySubscriberId(Long id);
    ResponseEntity<?> downloadPostImage(Long postId);
}
