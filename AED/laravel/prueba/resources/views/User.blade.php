<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>

        </style>

    </head>
    <body class="antialiased">
        <h1>User: {{session()->get("name")}}</h1>
        <br/>
        <p>Description: {{session()->get("desc")}}</p>
    </body>
</html>
