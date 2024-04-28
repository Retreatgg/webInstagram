package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {

    private Long id;
    private Long authorId;
    private Long comments;
    private Long likes;
    private String photo;
    private String info;
    private LocalDateTime timePost;
}
