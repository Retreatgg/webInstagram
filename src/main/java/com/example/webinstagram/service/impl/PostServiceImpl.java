package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.PostDao;
import com.example.webinstagram.dto.PostCreateDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.models.Post;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDao postDao;
    private final FileUtil fileUtil;


    @Override
    public void createPost(Authentication authentication, PostCreateDto postCreateDto) {
        Post post = new Post();
        User user = new User();

        String fileName = fileUtil.saveUploadedFile(postCreateDto.getPhoto(), "images");

        post.setTimePost(LocalDateTime.now());
        post.setInfo(postCreateDto.getInfo());
        post.setLikes(0L);
        post.setPhoto(fileName);
        post.setAuthorId(user.getId());
        post.setComments(0L);
        post.setIsActive(true);

        postDao.createPost(post);
    }

    @Override
    public List<PostDto> getPostsByAuthorId(Long id) {
        List<Post> posts = postDao.getPostsByAuthorId(id);
        List<PostDto> postDtos = new ArrayList<>();

        return postsToDto(posts, postDtos);
    }

    private List<PostDto> postsToDto(List<Post> posts, List<PostDto> postDtos) {
        posts.forEach(p -> {
            postDtos.add(PostDto.builder()
                    .timePost(p.getTimePost())
                            .photo(p.getPhoto())
                            .likes(p.getLikes())
                            .info(p.getInfo())
                            .authorId(p.getAuthorId())
                            .comments(p.getComments())
                            .id(p.getId())
                    .build());
        });

        return postDtos;
    }
}
