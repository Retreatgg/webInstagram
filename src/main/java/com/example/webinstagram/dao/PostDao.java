package com.example.webinstagram.dao;

import com.example.webinstagram.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void createPost(Post post) {
        String sql = """
                insert into posts(author_id, comments, likes, photo, info, time_post, IS_ACTIVE)
                VALUES ( :author_id, :comments, :likes, :photo, :info, :time_post, :is_active)
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("author_id", post.getAuthorId())
                .addValue("comments", post.getComments())
                .addValue("likes", post.getLikes())
                .addValue("photo", post.getPhoto())
                .addValue("info", post.getInfo())
                .addValue("time_post", post.getTimePost())
                .addValue("is_active", post.getIsActive()));
    }

    public List<Post> getPostsByAuthorId(Long id) {
        String sql = """
                select * from posts
                where author_id = ?
                and is_active = true
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }

    public Optional<Post> getPostById(Long id) {
        String sql = """
                select * from posts where id = ?
                """;

        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), id)
                )
        );
    }

    public void delete(Long postId) {
        String sql = """
                update posts 
                set is_active = false
                where id = ?
                """;

        jdbcTemplate.update(sql, postId);
    }

    public void updatePostById(Post post, Long id) {
        String sql = """
                update posts set likes = ?
                where id = ?
                """;

        jdbcTemplate.update(sql, post.getLikes(), id);
    }

    public List<Post> getPostsBySubscriberId(Long id) {
        String sql = """
                SELECT p.*
                FROM subscribes s
                JOIN users u ON s.subscription_id = u.id
                JOIN posts p ON u.id = p.author_id
                WHERE s.subscriber_id = ?  
                and p.IS_ACTIVE = true;   
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }

    public String getPostImage(Long postId) {
        String sql = """
                select photo from posts
                where id like ?
                """;

        return jdbcTemplate.queryForObject(sql, String.class, postId);
    }
}
