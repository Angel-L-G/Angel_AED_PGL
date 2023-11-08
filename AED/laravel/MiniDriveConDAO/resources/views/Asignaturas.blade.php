<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ asset('css/index.css') }}">

    </head>
    <body class="antialiased">
        <div class="container">
            <div>
                <h2>Agregar Asignatura</h2>
                <form action="createAsig" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Curso:</label><input type="text" id="curso" name="curso"><br/>
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Borrar Asignatura</h2>
                <form action="deleteAsig" method="post">
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Editar Asignatura</h2>
                <form action="updateAsig" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Curso:</label><input type="text" id="curso" name="curso"><br/>
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Mostrar Asignatura</h2>
                <form action="showAsig" method="post">
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            @isset($asignaturas)
                <ul>
                    @foreach($asignaturas as $a)
                        <li>{{$a}}</li>
                    @endforeach
                </ul>
            @endisset
        </div>
    </body>
</html>
