package com.example.webinstagram.service;

import com.example.webinstagram.dto.CommentCreateDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    void createComment(Authentication auth, Long postId, CommentCreateDto commentCreateDto);

    void delete(Authentication auth, Long postId, Long commentId);

    void deleteCommentsByPostId(Long postId);
}
