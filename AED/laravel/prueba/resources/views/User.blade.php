<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ asset('css/index.css') }}">

    </head>
    <body class="antialiased">
        <div class="container">
            <h1>User: {{session()->get("name")}}</h1>
            <br/>
            <div class="form-container">
                <form action="logOut">
                    <button type="submit" class="form-button">Log Out</button>
                </form>
            </div>
        </div>
    </body>
</html>
