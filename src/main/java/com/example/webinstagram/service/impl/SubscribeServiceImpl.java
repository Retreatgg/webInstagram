package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.SubscribeDao;
import com.example.webinstagram.models.Subscribe;
import com.example.webinstagram.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeDao subscribeDao;

    @Override
    public void subscribe(Long subscriberId, Long subscriptionId) {
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscriberId(subscriberId);
        subscribe.setSubscriptionId(subscriptionId);
        subscribe.setTime(LocalDateTime.now());
        subscribe.setIsActive(true);

        subscribeDao.subscribe(subscribe);
    }


}
