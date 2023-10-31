<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ asset('css/index.css') }}">

    </head>
    <body class="antialiased">
        <div class="container">
            <h2>{{ session()->get("user")->name }}</h2>
            @isset($ficheros)
                <ul>
                @foreach($ficheros as $fich)
                    <li><a href="/Download/{{basename($fich)}}">{{ $fich }}</a></li>
                    <a href="/Delete/{{basename($fich)}}" class="Button">Delete</a>
                @endforeach
                </ul>
            @endisset

            <a href="/showUpload">Upload Files</a>
        </div>
    </body>
</html>
