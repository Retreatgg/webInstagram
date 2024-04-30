package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.CommentDao;
import com.example.webinstagram.dto.CommentCreateDto;
import com.example.webinstagram.dto.CommentDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.models.Comment;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.CommentService;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.service.UserService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final UserUtil userUtil;
    private final PostService postService;
    private final UserService userService;

    @Override
    public void createComment(Authentication auth, Long postId, CommentCreateDto commentCreateDto) {
        if(commentCreateDto.getComment().isEmpty()) {
            String error = "Comment can't be is empty";
            log.error(error);
            throw new IllegalArgumentException(error);
        }

        Comment comment = new Comment();
        User userAuth = userUtil.getUserByAuth(auth);

        comment.setComment(commentCreateDto.getComment());
        comment.setAuthorId(userAuth.getId());
        comment.setPostId(postId);
        comment.setTime(LocalDateTime.now());
        comment.setIsActive(true);

        commentDao.createComment(comment);
    }

    @Override
    public void delete(Authentication auth, Long postId, Long commentId) {
        User user = userUtil.getUserByAuth(auth);
        PostDto postDto = postService.getPostById(postId);

        if(user.getId() == postDto.getAuthorId()) {
            commentDao.delete(commentId);
        }
    }

    @Override
    public void deleteCommentsByPostId(Long postId) {
        commentDao.deleteCommentsByPostId(postId);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long id) {
        List<Comment> comments = commentDao.getCommentsByPostId(id);
        List<CommentDto> dtos = new ArrayList<>();

        comments.forEach(com -> {
            dtos.add(CommentDto.builder()
                            .post(postService.getPostById(com.getPostId()))
                            .author(userService.getUserById(com.getAuthorId()))
                            .isActive(com.getIsActive())
                            .comment(com.getComment())
                            .time(com.getTime())
                    .build());
        });

        return dtos;
    }


}
