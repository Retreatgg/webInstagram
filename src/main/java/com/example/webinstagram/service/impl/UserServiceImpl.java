package com.example.webinstagram.service.impl;

import com.example.webinstagram.dao.UserDao;
import com.example.webinstagram.dto.UserCreateDto;
import com.example.webinstagram.dto.UserDto;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.UserService;
import com.example.webinstagram.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final FileUtil fileUtil;

    @Override
    public void registerUser(UserCreateDto user) {
        User newUser = transformUser(user);
        userDao.registerUser(newUser);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userOptionalCheck(email);

        return UserDto.builder()
                .posts(user.getPosts())
                .name(user.getName())
                .username(user.getUsername())
                .aboutInfo(user.getAboutInfo())
                .subscribes(user.getSubscribes())
                .subscriptions(user.getSubscriptions())
                .email(user.getEmail())
                .build();
    }

    @Override
    public ResponseEntity<?> downloadImage(String email) {
        UserDto userDto = getUserByEmail(email);
        String file = userDto.getAvatar();
        Optional<User> userOptional = userDao.getUserByEmail(email);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            String avatar = user.getAvatar();
            return fileUtil.getOutputFile(avatar, "/images");
        }

        return null;
    }

    private User transformUser(UserCreateDto userDto) {
        User user = new User();

        user.setAboutInfo(userDto.getAboutInfo());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEnabled(true);
        user.setEmail(userDto.getEmail());
        user.setPosts(0L);
        user.setSubscribes(0L);
        user.setSubscriptions(0L);

        return user;
    }

    private User userOptionalCheck(String email) {
        Optional<User> userOptional = userDao.getUserByEmail(email);

        if(!userOptional.isPresent()) {
            String error = "User is not found";
            log.error(error);
            throw new NoSuchElementException("User is not found");
        }

        return userOptional.get();
    }
}
