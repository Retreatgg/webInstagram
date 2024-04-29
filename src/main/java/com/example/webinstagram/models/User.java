package com.example.webinstagram.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String aboutInfo;
    private Long subscriptions;
    private Long subscribes;
    private String avatar;
    private Long posts;
    private Boolean enabled;

}
