package com.example.webinstagram.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Post {

    private Long id;
    private Long authorId;
    private Long comments;
    private Long likes;
    private String photo;
    private String info;
    private LocalDateTime timePost;

}
