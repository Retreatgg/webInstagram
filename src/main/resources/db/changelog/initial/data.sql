insert into AUTHORITIES(AUTHORITY)
values ( 'USER' );

insert into USERS(name, username, email, password, about_info, subscriptions, subscribes, avatar, posts, enabled)
VALUES ( 'test', 'qwe0', 'qwe@qwe', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 5, 5, 'unnamed.jpg', 1, true );

insert into USER_AUTHORITY(user_id, authority_id)
VALUES ( 1, 1 );

insert into POSTS(AUTHOR_ID, COMMENTS, LIKES, PHOTO, INFO, TIME_POST, IS_ACTIVE)
values ( 1, 5, 5, 'unnamed.jpg', 'test info', current_timestamp(), true);

insert into COMMENTS(AUTHOR_ID, POST_ID, COMMENT, TIME, IS_ACTIVE)
VALUES ( 1, 1, 'test', current_timestamp(), true);

insert into LIKES(user_id, post_id, time)
VALUES ( 1, 1, current_timestamp());

insert into SUBSCRIBES(subscription_id, subscriber_id, is_active, time)
VALUES ( 1, 1, true, current_timestamp() );