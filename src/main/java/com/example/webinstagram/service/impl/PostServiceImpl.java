package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.PostDao;
import com.example.webinstagram.dto.PostCreateDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.models.Post;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.util.FileUtil;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDao postDao;
    private final FileUtil fileUtil;
    private final UserUtil userUtil;


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

    @Override
    public PostDto getPostById(Long id) {
        Post post = checkOptional(id);

        return PostDto.builder()
                .timePost(post.getTimePost())
                .photo(post.getPhoto())
                .likes(post.getLikes())
                .id(post.getId())
                .comments(post.getComments())
                .authorId(post.getId())
                .build();
    }

    @Override
    public void delete(Authentication auth, Long postId) {
        User user = userUtil.getUserByAuth(auth);
        PostDto post = getPostById(postId);

        if(user.getId() == post.getAuthorId()) {
            postDao.delete(postId);
        }
    }

    private Post checkOptional(Long id) {
        Optional<Post> post = postDao.getPostById(id);
        if(!post.isPresent()) {
            String error = "Post is not found by ID: " + id;
            log.error(error);
            throw new NoSuchElementException(error);
        }

        return post.get();
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
