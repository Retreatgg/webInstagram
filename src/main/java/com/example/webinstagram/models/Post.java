package com.example.webinstagram.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {

    private Long id;
    private Long authorId;
    private Long comments;
    private Long likes;
    private String photo;
    private String info;
    private LocalDateTime timePost;

}
