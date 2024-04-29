package com.example.webinstagram.dao;

import com.example.webinstagram.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void registerUser(User user) {
        String sql = """
                insert into users(name, username, email, password, about_info, subscriptions, subscribers, avatar, posts, enabled) 
                VALUES ( :name, :username, :email, :password, :about_info, :subscriptions, :subscribes, :avatar, :posts, :enabled)
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("name", user.getName())
                .addValue("username", user.getUsername())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("about_info", user.getAboutInfo())
                .addValue("subscriptions", user.getSubscriptions())
                .addValue("subscribes", user.getSubscribes())
                .addValue("avatar", user.getAvatar())
                .addValue("posts", user.getPosts())
                .addValue("enabled", user.getEnabled()));
    }

    public Optional<User> getUserByEmail(String email) {
        String sql = """
                select * from users
                where email like ?
                """;

        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
                )
        );
    }
}
