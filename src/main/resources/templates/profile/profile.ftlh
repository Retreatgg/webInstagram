<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="author" content="George W. Park">
    <meta name="description" content="This project demonstrates how CSS grid (with flexbox and float fallback) can be used to re-create the layout of an Instagram profile page.">

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

                <img src="https://images.unsplash.com/photo-1513721032312-6a18a42c8763?w=152&h=152&fit=crop&crop=faces" alt="">

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
                    <img class="img-fluid" src="/images/download/${user.email}" alt="${user.avatar}">
                    <button id="btn-like" class="like-button">
                        <i class="far fa-heart"></i>
                    </button>

                    <button id="btn-delete" class="delete-button">
                        <i class="far fa-trash-alt"></i>
                    </button>
                </span>
                    <div class="caption">
                        <b>${post.likes} likes</b>
                        <p>
                            <b>${user.name}: </b>
                            ${post.info}
                        </p>

                    </div>
                    <div class="add-comment">
                        <p>Add a comment...</p>
                        <i class="fa-solid fa-face-smile"></i>
                    </div>
                </div>

            <script>
                let btnDelete = document.getElementById('btn-delete').addEventListener('click', deletePost)
                let btnLike = document.getElementById('btn-like').addEventListener('click', like)

                function like() {
                    fetch(`/like/${post.id}`)
                }

                function deletePost() {
                    fetch(`/delete/${post.id}`)
                }
            </script>
        </#list>

    </div>

</main>

</body>

</html>