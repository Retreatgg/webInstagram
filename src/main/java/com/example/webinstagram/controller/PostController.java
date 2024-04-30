package com.example.webinstagram.controller;


import com.example.webinstagram.dto.CommentCreateDto;
import com.example.webinstagram.dto.CommentDto;
import com.example.webinstagram.dto.PostDto;
import com.example.webinstagram.dto.PostMainDto;
import com.example.webinstagram.models.User;
import com.example.webinstagram.service.CommentService;
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

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;
    private final LikeService likeService;
    private final CommentService commentService;
    private final UserUtil userUtil;

    @GetMapping("")
    public String posts(Authentication auth, Model model) {
        User user = userUtil.getUserByAuth(auth);
        List<PostMainDto> posts = postService.getPostsBySubscriberId(user.getId());
        model.addAttribute("posts", posts);
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

    @GetMapping("comment/{id}")
    public String comments(@PathVariable Long id, Model model) {
        List<CommentDto> commentDtos = commentService.getCommentsByPostId(id);
        model.addAttribute("comments",commentDtos);

        return "comment/comments";
    }

    @PostMapping("comments/post/{id}")
    public String createNewComment(Authentication auth, @PathVariable Long id, CommentCreateDto comment) {
        commentService.createComment(auth, id, comment);
        System.out.println(comment.getComment());

        return "redirect:/comment/" + id;
    }

}
