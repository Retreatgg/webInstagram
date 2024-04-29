package com.example.webinstagram.dao;

import com.example.webinstagram.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void createComment(Comment comment) {
        String sql = """
                insert into COMMENTS(author_id, post_id, comment, time, IS_ACTIVE) 
                VALUES ( :author_id, :post_id, :comment, :time, :is_active )
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("author_id", comment.getAuthorId())
                .addValue("post_id", comment.getPostId())
                .addValue("comment", comment.getComment())
                .addValue("time", comment.getTime())
                .addValue("is_active", comment.getIsActive()));
    }

    public void delete(Long commentId) {
        String sql = """
                update comments set is_active = false 
                where id = ?
                """;

        jdbcTemplate.update(sql, commentId);
    }

    public void deleteCommentsByPostId(Long postId) {
        String sql = """
                update comments set is_active = false
                where post_id = ?
                """;

        jdbcTemplate.update(sql, postId);
    }
}
