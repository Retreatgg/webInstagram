package com.example.webinstagram.controller;


import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;
    private final UserUtil userUtil;

    @GetMapping("")
    public String posts(Authentication authentication, Model model) {
        User user = userUtil.getUserByAuth(authentication);
        return "";
    }
}
