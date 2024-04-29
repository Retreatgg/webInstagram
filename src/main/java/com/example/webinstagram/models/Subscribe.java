package com.example.webinstagram.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Subscribe {

    private Long id;
    private Long subscriptionId;
    private Long subscriberId;
    private Boolean isActive;
    private LocalDateTime time;

}
