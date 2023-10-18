<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body class="antialiased">
    <table>
        @foreach ($coleccion as $primo)
            <tr><td> primo: {{$primo}} </td></tr>
        @endforeach
    </table>
    </body>
</html>
