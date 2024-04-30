package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostMainDto {

    private Long id;
    private UserDto author;
    private Long comments;
    private Long likes;
    private String photo;
    private String info;
    private LocalDateTime timePost;
}
