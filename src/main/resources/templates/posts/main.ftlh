<#import "../layout.ftlh" as main>
<@main.layout>

    <#if posts??>
        <#list posts as post>

            <div class="card mt-5">
                <img class="img-fluid" src="/images/post/download/${post.id}" alt="${post.id}">
                <button type="button" id="btn-like" class="btn" data-post-id="${post.id}">
                    <a href="/post/like/${post.id}">Like</a>
                </button>

                </span>
                <div class="caption">
                    <b>${post.likes} likes</b>
                    <p>
                        <b>${post.author.name}: </b>
                        ${post.info}
                    </p>

                </div>
                <button id="comment-btn" class="add-comment-button" data-post-id="${post.id}">
                    <i class="fa-solid fa-face-smile"></i> <a href="/comment/${post.id}">Add a comment...</a>
                </button>
            </div>


        </#list>

        </div>
    </#if>

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