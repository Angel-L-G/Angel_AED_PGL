<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ asset('css/index.css') }}">

    </head>
    <body class="antialiased">
        <div class="container">
            <div class="form-container">
                <form action="logIn" method="post">
                    @csrf
                    <label class="form-label">Name</label>
                    <input type="text" name="name" required>
                    <br/>
                    <label class="form-label">Nick</label>
                    <input type="text" name="nick" required>
                    <br/>
                    <label class="form-label">password</label>
                    <input type="password" name="psswrd" required>
                    <br/>
                    <button type="submit" class="form-button">Log In</button>
                </form>
            </div>
            <a href="/showRegister">Registrate</a>
        </div>

    </body>
</html>
