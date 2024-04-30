<#import "../layout.ftlh" as main>
<@main.layout>

    <h1>Comments</h1>

    <ul class="comments">
        <#list comments as comment>

            <li class="comment">
                <#if user??>
                    <button class="delete-button" style="float:right;">×</button>
                </#if>
                <strong>${comment.author.name}:</strong>
                <span class="comment-text">${comment.comment}</span>
            </li>


        </#list>
    </ul>

    <form id="form" class="comment-form">
        <textarea rows="4" placeholder="Add a comment..." name="comment"></textarea>
        <button type="submit" id="btn">Add Comment</button>
    </form>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .comments {
            margin-top: 20px;
            list-style-type: none;
            padding: 0;
        }

        .comment {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
        }

        .comment:last-child {
            border-bottom: none;
        }

        .comment-text {
            margin-left: 20px;
        }

        .comment-form {
            margin-top: 20px;
        }

        .comment-form textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-bottom: 10px;
        }

        .comment-form button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        .comment-form button:hover {
            background-color: #45a049;
        }
    </style>

    <script>
        document.getElementById('form').addEventListener('submit', function (event) {
            event.preventDefault();

            const formData = new FormData(this);


            fetch('/comments/post/${comments[0].post.id}', {
                method: 'POST',
                body: formData
            })
                .then(response => {
                    if (response.ok) {
                        location.reload();
                        я
                    } else {
                        console.error('Error:', response.statusText);
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
    </script>

</@main.layout>