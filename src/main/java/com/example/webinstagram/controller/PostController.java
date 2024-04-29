package com.example.webinstagram.controller;


import com.example.webinstagram.models.User;
import com.example.webinstagram.service.LikeService;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;
    private final LikeService likeService;
    private final UserUtil userUtil;

    @GetMapping("")
    public String posts(Model model) {
        // User user = userUtil.getUserByAuth(authentication);
        return "posts/main";
    }

    @GetMapping("like/{id}")
    public String like(Authentication authentication, @PathVariable Long id) {
        User user = userUtil.getUserByAuth(authentication);
        likeService.like(id, user.getId());
        postService.like(id);
        return "redirect:/profile";
    }

    @GetMapping("delete/{id}")
    public String delete(Authentication authentication, @PathVariable Long id) {
        postService.delete(authentication, id);
        return "redirect:/profile";
    }


}
