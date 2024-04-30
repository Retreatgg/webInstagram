package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.SubscribeDao;
import com.example.webinstagram.dao.UserDao;
import com.example.webinstagram.models.Subscribe;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.SubscribeService;
import com.example.webinstagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeDao subscribeDao;
    private final UserDao userDao;

    @Override
    public void subscribe(Long subscriberId, Long subscriptionId) {
        User subscriber = userDao.getUserById(subscriberId).get();
        User subscription = userDao.getUserById(subscriptionId).get();
        Subscribe subscribe = new Subscribe();

        subscribe.setSubscriberId(subscriberId);
        subscribe.setSubscriptionId(subscriptionId);
        subscribe.setTime(LocalDateTime.now());
        subscribe.setIsActive(true);

        subscribeDao.subscribe(subscribe);

        subscriber.setSubscriptions(subscriber.getSubscriptions() + 1);
        subscription.setSubscribes(subscription.getSubscriptions() + 1);
    }


}
