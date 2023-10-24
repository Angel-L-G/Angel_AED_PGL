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
                <form action="Upload" method="post">
                    @csrf
                    <label for="fichero">sube fichero</label>
                    <input type="file" name="myfile" id="fichero">
                    <br/>
                    <button type="submit" class="form-button">Log In</button>
                </form>
            </div>
            <a href="/showFiles">Home</a>
        </div>
    </body>
</html>
