<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ asset('css/index.css') }}">

    </head>
    <body class="antialiased">
        <div class="container">
            <a href="asignaturas">Asignaturas</a><br/>
            <a href="alumnos">Alumnos</a><br/>
            <a href="matriculas">Matriculas</a><br/>
        </div>
    </body>
</html>
