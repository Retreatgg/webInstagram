insert into AUTHORITIES(AUTHORITY)
values ( 'USER' );

insert into USERS(name, username, email, password, about_info, subscriptions, subscribes, avatar, posts, enabled)
VALUES ( 'qwe', 'qwe0', 'qwe@qwe.qwe', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 2, 1, 'unnamed.jpg', 1, true ),
       ( 'test', 'test', 'test@test.test', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'Alex', 'alexColl', 'alex@email.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'baby', 'Baby', 'baby@qwe.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'Genius', 'Genius', 'Genius@qwe.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'cool', 'cool', 'cool@qwe.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'new', 'new', 'new@qwe.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true ),
       ( 'home', 'home', 'home@qwe.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'test account', 1, 1, 'unnamed.jpg', 1, true );

insert into USER_AUTHORITY(user_id, authority_id)
VALUES ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 ),
       ( 1, 1 );

insert into POSTS(AUTHOR_ID, COMMENTS, LIKES, PHOTO, INFO, TIME_POST, IS_ACTIVE)
values ( 1, 0, 1, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 2, 1, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 3, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 4, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 5, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 6, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 7, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true),
       ( 1, 0, 0, 'unnamed.jpg', 'test info', current_timestamp(), true);

insert into COMMENTS(AUTHOR_ID, POST_ID, COMMENT, TIME, IS_ACTIVE)
VALUES ( 1, 2, 'test', current_timestamp(), true);

insert into LIKES(user_id, post_id, time)
VALUES ( 1, 1, current_timestamp());

insert into SUBSCRIBES(subscription_id, subscriber_id, is_active, time)
VALUES ( 1, 1, true, current_timestamp()),
       ( 2, 1, true, current_timestamp()),
       ( 3, 2, true, current_timestamp()),
       ( 2, 3, true, current_timestamp()),
       ( 4, 5, true, current_timestamp()),
       ( 5, 4, true, current_timestamp()),
       ( 6, 7, true, current_timestamp()),
       ( 7, 6, true, current_timestamp()),
       ( 8, 1, true, current_timestamp());