package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreateDto {

    private String photo;
    private String info;

}
