package com.example.webinstagram.controller.api;

import com.example.webinstagram.service.PostService;
import com.example.webinstagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final UserService userService;
    private final PostService postService;

    @GetMapping("download/{email}")
    public ResponseEntity<?> download(@PathVariable String email) {
        return userService.downloadImage(email);
    }

    @GetMapping("post/download/{postId}")
    public ResponseEntity<?> imagePost(@PathVariable Long postId) {
        return postService.downloadPostImage(postId);
    }


}
