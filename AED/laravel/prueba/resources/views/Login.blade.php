<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>

        </style>

    </head>
    <body class="antialiased">
        <form action="showUser" method="post">
            @csrf
            <label for="">Name</label>
            <input type="text" name="name">
            <br/>
            <label for="">password</label>
            <input type="text" name="psswrd">
            <br/>
            <label for="">Description</label>
            <input type="text" name="desc">
            <br/>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
