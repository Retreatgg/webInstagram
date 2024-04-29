package com.example.webinstagram.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String name;
    private String username;
    private String email;
    private String aboutInfo;
    private Long subscriptions;
    private Long subscribes;
    private String avatar;
    private Long posts;
}
