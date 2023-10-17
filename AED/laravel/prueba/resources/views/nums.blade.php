<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body class="antialiased">
        <h1>Mayores</h1>
        <ol>
            @foreach ($arr as $num)
                @if ($num > 50)
                    <li>{{$num}}</li>
                @endif
            @endforeach
        </ol>
        <h1>Menores</h1>
        <ol>
            @foreach ($arr as $num)
                @if ($num < 50)
                    <li>{{$num}}</li>
                @endif
            @endforeach
        </ol>
    </body>
</html>
