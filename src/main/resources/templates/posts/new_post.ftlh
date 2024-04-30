<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="container">
        <form action="/create" method="post" enctype="multipart/form-data">
            <label for="photo">Photo:</label>
            <input type="file" id="photo" name="photo" accept="image/*" required><br><br>

            <label for="info">Info:</label><br>
            <textarea id="info" name="info" rows="4" cols="50" required></textarea><br><br>

            <input type="submit" value="Create Post">
        </form>
    </div>
</@main.layout>