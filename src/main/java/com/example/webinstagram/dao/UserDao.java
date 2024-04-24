package com.example.webinstagram.dao;

import com.example.webinstagram.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void registerUser(User user) {
        String sql = """
                insert into users(name, email, password, about_info, subscriptions, subscribers, avatar, posts, enabled) 
                VALUES ( :name , :email, :password, :about_info, :subscriptions, :subscribes, :avatar, :posts, :enabled)
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("about_info", user.getAboutInfo())
                .addValue("subscriptions", user.getSubscriptions())
                .addValue("subscribes", user.getSubscribes())
                .addValue("avatar", user.getAvatar())
                .addValue("posts", user.getPosts())
                .addValue("enabled", user.getEnabled()));
    }

}
