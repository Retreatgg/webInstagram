package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.UserDao;
import com.example.webinstagram.dto.UserCreateDto;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public void registerUser(UserCreateDto user) {
        User newUser = transformUser(user);
        userDao.registerUser(newUser);
    }

    private User transformUser(UserCreateDto userDto) {
        User user = new User();

        user.setAboutInfo(userDto.getAboutInfo());
        user.setName(userDto.getName());
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        user.setPosts(0L);
        user.setSubscribes(0L);
        user.setSubscriptions(0L);

        return user;
    }
}
