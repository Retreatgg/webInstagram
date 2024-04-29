package com.example.webinstagram.service;

import com.example.webinstagram.dto.LikeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {

    void like(Long postId, Long userId);
    List<LikeDto> getLikesByPostId(Long postId);

}
