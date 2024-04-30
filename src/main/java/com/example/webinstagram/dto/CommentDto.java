package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentDto {

    private Long id;
    private UserDto author;
    private PostDto post;
    private String comment;
    private LocalDateTime time;
    private Boolean isActive;
}
