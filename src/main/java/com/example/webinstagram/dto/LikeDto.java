package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LikeDto {

    private Long id;
    private Long userId;
    private Long postId;
    private LocalDateTime time;
}
