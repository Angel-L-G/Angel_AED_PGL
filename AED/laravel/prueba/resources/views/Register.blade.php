<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>

        </style>

    </head>
    <body class="antialiased">
        <form action="Register" method="post">
            @csrf
            <label for="">Name</label>
            <input type="text" name="name" required>
            <br/>
            <label for="">password</label>
            <input type="text" name="psswrd" required>
            <br/>
            <button type="submit">Register</button>
        </form>

        <a href="/showLogin">Logueate</a>
    </body>
</html>
