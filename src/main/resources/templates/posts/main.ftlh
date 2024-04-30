<#import "../layout.ftlh" as main>
<@main.layout>

    <#list posts as post>

        <div class="card mt-5">
            <img class="img-fluid" src="/images/download/${post.author.email}" alt="">

            </span>
            <div class="caption">
                <b>${post.likes} likes</b>
                <p>
                    <b>${post.author.name}: </b>
                    ${post.info}
                </p>

            </div>
            <button id="btn-like" class="like-button">
                <i class="far fa-heart fa-lg"></i>
            </button>


            <button id="comment-btn" class="add-comment-button">
                <i class="fa-solid fa-face-smile"></i> Add a comment...
            </button>
        </div>

        <script>
            let btnLike = document.getElementById('btn-like').addEventListener('click', like)

            function like() {
                fetch(`/like/${post.id}`)
            }


            let com = document.getElementById('comment-btn').addEventListener('click', comment)

            function comment() {
                fetch('/comment/${post.id}')
            }
        </script>
    </#list>

    <style>
        *{
            margin:0;
            padding:0;
        }

        .comment
        {
            display: flex;
            justify-content: space-between;
        }
        .comment > i
        {
            font-size:12px;
        }

        .add-comment
        {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            color: #888888;
        }


        .add-comment >i{
            font-size: 18px;
        }
        .topbar, .bottom
        {
            display: none;
        }

        @media screen and (max-width :800px)
        {
            .sidebar
            {
                display: none;
            }
            .main
            {
                width:100vw;
                box-sizing: border-box;
            }
            .card
            {
                width:90vw;
            }


    </style>

</@main.layout>