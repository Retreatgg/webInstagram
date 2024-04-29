package com.example.webinstagram.dao;

import com.example.webinstagram.models.Like;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LikeDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void like(Like like) {
        String sql = """
                insert into likes(user_id, post_id, time)
                values ( :user_id, :post_id, :time )
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("user_id", like.getUserId())
                .addValue("post_id", like.getPostId())
                .addValue("time", like.getTime()));
    }


    public List<Like> getLikesByPostId(Long postId) {
        String sql = """
               select * from likes
               where post_id = ?
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class), postId);
    }

    public Long getUserIdByPost(Long postId) {
        String sql = """
                select user_id from likes
                where post_id = ?
                """;

        return jdbcTemplate.queryForObject(sql, Long.class, postId);
    }
}
