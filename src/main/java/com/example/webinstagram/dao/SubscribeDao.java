package com.example.webinstagram.dao;

import com.example.webinstagram.models.Subscribe;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscribeDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void subscribe(Subscribe subscribe) {
        String sql = """
                insert into subscribes(subscription_id, subscriber_id, is_active, time)
                values ( :subscription_id,  :subscriber_id, :is_active, :time)
                """;

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("subscription_id", subscribe.getSubscriptionId())
                .addValue("subscriber_id", subscribe.getSubscriberId())
                .addValue("is_active", subscribe.getIsActive())
                .addValue("time", subscribe.getTime()));
    }


    public List<Subscribe> getSubscriptionsBySubscriberId(Long subscriberId) {
        String sql = """
                select * from subscribes
                where subscriber_id = ?
                and is_active = true
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscribe.class), subscriberId);
    }

    public List<Subscribe> getSubscriberBySubscriptionId(Long subscriptionId) {
        String sql = """
                select * from subscribes
                where subscription_id = ?
                and is_active = true
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscribe.class), subscriptionId);
    }
}
