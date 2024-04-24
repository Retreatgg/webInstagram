package com.example.webinstagram.dao;

import com.example.webinstagram.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void createPost(Post post) {
        String sql = """
                insert into posts(author_id, comments, likes, photo, info, time_post)
                VALUES ( :author_id, :comments, :likes, :photo, :info, :time_post)
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("author_id", post.getAuthorId())
                .addValue("comments", post.getComments())
                .addValue("likes", post.getLikes())
                .addValue("photo", post.getPhoto())
                .addValue("info", post.getInfo())
                .addValue("time_post", post.getTimePost()));
    }
}
