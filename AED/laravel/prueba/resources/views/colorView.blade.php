<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>

        </style>

    </head>
    <body class="antialiased">
        <h1>Colores</h1>
        <form action="/Pract13" method="post">
            @csrf
            <label>Inserte Los Colores</label>
            <input type="text" name="color" id="color"/>
            <input type="submit"/>
        </form>
        <ul>
            @if(@isset($arrColores))
                <li>Lista1</li>
                @foreach ($arrColores as $color)

                <li>Lista2</li>
                    <li>{{$color}}</li>
                @endforeach
            @endif
        </ul>
    </body>
</html>
