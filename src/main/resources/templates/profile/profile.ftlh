<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="author" content="George W. Park">
    <meta name="description"
          content="This project demonstrates how CSS grid (with flexbox and float fallback) can be used to re-create the layout of an Instagram profile page.">

    <title>Instagram Profile Layout</title>

    <link rel="stylesheet" href="../../static/reset.css">
    <link rel="stylesheet" href="../../static/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

</head>
<body>

<header>

    <div class="container">

        <div class="profile">

            <div class="profile-image">

                <img src="/images/download/${user.email}"
                     alt="">

            </div>

            <div class="profile-user-settings">

                <h1 class="profile-user-name">${user.username}</h1>

            </div>

            <div class="profile-stats">

                <ul>
                    <li><span class="profile-stat-count">${user.posts}</span> posts</li>
                    <li><span class="profile-stat-count">${user.subscriptions}</span> followers</li>
                    <li><span class="profile-stat-count">${user.subscribes}</span> following</li>
                </ul>

                <#if guest??>
                    <button id="subscribe" class="subscribe-button">
                                Subscribe</button>
                <#else>
                    <button class="btn"><a href="/create">Add new post</a></button>
                </#if>


            </div>

            <div class="profile-bio">

                <p><span class="profile-real-name">${user.name}: </span> ${user.aboutInfo}</p>
            </div>

        </div>

    </div>

</header>

<main>

    <div class="container">

        <#list posts as post>

            <div class="card mt-5">
                <img class="img-fluid" src="/images/post/download/${post.id}" alt="${post.id}">
                <button type="button" id="btn-like" class="btn" data-post-id="${post.id}">
                    <a href="/post/like/${post.id}">Like</a>
                </button>

                <#if guest??>
                <#else>
                    <button id="btn-delete" class="delete-button" data-post-id="${post.id}">
                        delete
                    </button>
                </#if>
                </span>
                <div class="caption">
                    <b>${post.likes} likes</b>
                    <p>
                        <b>${user.name}: </b>
                        ${post.info}
                    </p>

                </div>
                <button id="comment-btn" class="add-comment-button" data-post-id="${post.id}">
                    <i class="fa-solid fa-face-smile"></i> <a href="/comment/${post.id}">Add a comment...</a>
                </button>
            </div>

            <script>
                let btn = document.getElementById('btn-delete').addEventListener('click', deletePost)

                async function deletePost() {
                    fetch('/post/delete/${post.id}', {
                        method: 'POST'
                    })
                }

                let subscribeBtn = document.getElementById('subscribe').addEventListener('click', subscribe)

                async function subscribe() {
                    await fetch('/profile/subscribe/${user.id}', {
                        method: 'POST'
                    })
                }
            </script>

        </#list>

    </div>

</main>

</body>

</html>