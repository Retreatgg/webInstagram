package com.example.webinstagram.controller;


import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.dto.UserDto;
import com.example.webinstagram.models.Post;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.PostService;
import com.example.webinstagram.service.SubscribeService;
import com.example.webinstagram.service.UserService;
import com.example.webinstagram.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("profile")
public class ProfileController {

    private final UserService userService;
    private final PostService postService;
    private final UserUtil userUtil;
    private final SubscribeService subscribeService;

    @GetMapping("")
    public String profile(Authentication auth, Model model) {
        User user = userUtil.getUserByAuth(auth);
        List<PostDto> posts = postService.getPostsByAuthorId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("posts", posts);

        return "profile/profile";
    }


    @GetMapping("{id}")
    public String getProfileById(@PathVariable Long id, Authentication auth, Model model) {
        if(auth != null) {
            User user = userUtil.getUserByAuth(auth);
            UserDto userDto = userService.getUserById(id);
            if(user.getEmail().equals(userDto.getEmail())) {
                List<PostDto> posts = postService.getPostsByAuthorId(user.getId());
                model.addAttribute("posts", posts);
            } else {
                List<PostDto> posts = postService.getPostsByAuthorId(userDto.getId());
                model.addAttribute("guest", userDto);
                model.addAttribute("posts", posts);
            }

            model.addAttribute("user", userDto);
        }


        return "profile/profile";
    }


    @GetMapping("subscribe/{id}")
    public String subscribe(Authentication auth, @PathVariable Long id) {
        User user = userUtil.getUserByAuth(auth);
        subscribeService.subscribe(user.getId(), id);
        return "redirect:/";
    }
}
