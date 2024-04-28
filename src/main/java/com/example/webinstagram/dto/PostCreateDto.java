package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class PostCreateDto {

    private MultipartFile photo;
    private String info;

}
