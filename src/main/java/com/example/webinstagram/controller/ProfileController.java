package com.example.webinstagram.controller;


import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.models.Post;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.service.UserService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("profile")
public class ProfileController {

    private final UserService userService;
    private final PostService postService;
    private final UserUtil userUtil;

    @GetMapping("")
    public String profile(Authentication auth, Model model) {
        User user = userUtil.getUserByAuth(auth);
        List<PostDto> posts = postService.getPostsByAuthorId(user.getId());
        System.out.println(user.toString());

        model.addAttribute("user", user);
        model.addAttribute("posts", posts);

        return "profile/profile";
    }
}
