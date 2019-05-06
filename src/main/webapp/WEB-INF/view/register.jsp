<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <div>
            <h1>Registration</h1>
        </div>
        <form action="/register" method="post">
            <label for="login">Login: </label><br>
            <input type="text" id="login" name="login"><br>
            <label for="login">Password: </label><br>
            <input type="text" id="password" name="password"><br><br>
            <input type="submit" value="Send">
        </form>
        <br>
        <div>
            <a href="/">Login</a>
        </div>
    </body>
</html>