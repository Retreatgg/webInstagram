package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentCreateDto {

    private String comment;

}
