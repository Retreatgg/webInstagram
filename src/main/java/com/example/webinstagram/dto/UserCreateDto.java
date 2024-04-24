package com.example.webinstagram.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class UserCreateDto {

    private String name;
    private String email;
    private String password;
    private String aboutInfo;
    private MultipartFile photo;

}
