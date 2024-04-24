package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.CommentDao;
import com.example.webinstagram.dto.CommentCreateDto;
import com.example.webinstagram.models.Comment;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    @Override
    public void createComment(Authentication auth, Long postId, CommentCreateDto commentCreateDto) {
        User user = new User();
        Comment comment = new Comment();

        comment.setComment(commentCreateDto.getComment());
        comment.setAuthorId(user.getId());
        comment.setPostId(postId);
        comment.setTime(LocalDateTime.now());

        commentDao.createComment(comment);
    }
}
