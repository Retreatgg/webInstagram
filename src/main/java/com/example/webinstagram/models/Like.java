package com.example.webinstagram.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Like {

    private Long id;
    private Long userId;
    private Long postId;
    private LocalDateTime time;

}
