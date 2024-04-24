package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.PostDao;
import com.example.webinstagram.dto.PostCreateDto;
import com.example.webinstagram.models.Post;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDao postDao;


    @Override
    public void createPost(Authentication authentication, PostCreateDto postCreateDto) {
        Post post = new Post();
        User user = new User();

        post.setTimePost(LocalDateTime.now());
        post.setInfo(postCreateDto.getInfo());
        post.setLikes(0L);
        post.setPhoto(postCreateDto.getPhoto());
        post.setAuthorId(user.getId());
        post.setComments(0L);

        postDao.createPost(post);
    }
}
