package com.example.webinstagram.service;

import com.example.webinstagram.dto.CommentCreateDto;
import com.example.webinstagram.dto.CommentDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    void createComment(Authentication auth, Long postId, CommentCreateDto commentCreateDto);

    void delete(Authentication auth, Long postId, Long commentId);

    void deleteCommentsByPostId(Long postId);

    List<CommentDto> getCommentsByPostId(Long id);
}
