package com.example.webinstagram.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {

    private Long id;
    private Long authorId;
    private Long postId;
    private String comment;
    private LocalDateTime time;

}
