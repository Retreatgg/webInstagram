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

                <h1 class="profile-user-name">janedoe_</h1

            </div>

            <div class="profile-stats">

                <ul>
                    <li><span class="profile-stat-count">164</span> posts</li>
                    <li><span class="profile-stat-count">188</span> followers</li>
                    <li><span class="profile-stat-count">206</span> following</li>
                </ul>

            </div>

            <div class="profile-bio">

                <p><span class="profile-real-name">Jane Doe</span> Lorem ipsum dolor sit, amet consectetur adipisicing elit рџ“·вњ€пёЏрџЏ•пёЏ</p>

            </div>

        </div>

    </div>

</header>

<main>

    <div class="container">

        <div class="card mt-3">
            <img class="main-img" src="data:image/jpeg;base64,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" alt="">
            <span class="icon-area">
                    <span>
                        <i class="fa-solid fa-heart"></i>
                        <i class="fa-solid fa-comment fa-flip-horizontal"></i>
                        <i class="fa-solid fa-paper-plane"></i>
                    </span>
                    <i class="fa-solid fa-bookmark"></i>

                </span>
            <div class="caption">
                <b>149 likes</b>
                <p>
                    <b>iloveCoding</b>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Laudantium accusantium, quisquam magnam, rem non delectus quod voluptas officia sit voluptatibus nihil pariatur in, et officiis tempore ullam repellat culpa aut! рџ’›
                </p>

            </div>
            <div class="add-comment">
                <p>Add a comment...</p>
                <i class="fa-solid fa-face-smile"></i>
            </div>
        </div>

    </div>

</main>

</body>
</html>