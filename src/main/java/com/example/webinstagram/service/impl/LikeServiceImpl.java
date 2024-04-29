package com.example.webinstagram.service.impl;


import com.example.webinstagram.dao.LikeDao;
import com.example.webinstagram.dto.LikeDto;
import com.example.webinstagram.models.Like;
import com.example.webinstagram.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeDao likeDao;

    @Override
    public void like(Long postId, Long userId) {
        Like like = new Like();

        like.setTime(LocalDateTime.now());
        like.setUserId(userId);
        like.setPostId(postId);

        likeDao.like(like);
    }

    @Override
    public List<LikeDto> getLikesByPostId(Long postId) {
        List<Like> likeList = likeDao.getLikesByPostId(postId);
        List<LikeDto> likes = new ArrayList<>();

        likeList.forEach(like -> {
            likes.add(LikeDto.builder()
                            .id(like.getId())
                            .postId(like.getPostId())
                            .time(like.getTime())
                            .userId(like.getUserId())
                    .build());
        });

        return likes;
    }
}
