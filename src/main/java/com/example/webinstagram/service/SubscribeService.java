package com.example.webinstagram.service;

import org.springframework.stereotype.Service;

@Service
public interface SubscribeService {

    void subscribe(Long subscriberId, Long subscriptionId);
}
