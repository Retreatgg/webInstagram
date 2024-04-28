package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.CommentDao;
import com.example.webinstagram.dto.CommentCreateDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.models.Comment;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.CommentService;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final UserUtil userUtil;
    private final PostService postService;

    @Override
    public void createComment(Authentication auth, Long postId, CommentCreateDto commentCreateDto) {
        User user = new User();
        Comment comment = new Comment();

        comment.setComment(commentCreateDto.getComment());
        comment.setAuthorId(user.getId());
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

}
