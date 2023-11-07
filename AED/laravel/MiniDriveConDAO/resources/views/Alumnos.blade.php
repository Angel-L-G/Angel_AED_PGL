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
                <h2>Agregar Alumno</h2>
                <form action="" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Apellidos:</label><input type="text" id="apellidos" name="apellidos"><br/>
                    <label>Nacimiento:</label><input type="text" id="fecha" name="fecha"><br/>
                    <label>DNI:</label><input type="text" id="dni" name="dni"><br/>
                </form>
            </div>
            <div>
                <h2>Borrar Alumno</h2>
                <form action="" method="post">
                    <label>DNI:</label><input type="text" id="dni" name="dni">
                </form>
            </div>
            <div>
                <h2>Editar Alumno</h2>
                <form action="" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Apellidos:</label><input type="text" id="apellidos" name="apellidos"><br/>
                    <label>Nacimiento:</label><input type="text" id="fecha" name="fecha"><br/>
                    <label>DNI:</label><input type="text" id="dni" name="dni"><br/>
                </form>
            </div>
            <div>
                <h2>Mostrar Alumno</h2>
                <form action="" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>DNI:</label><input type="text" id="dni" name="dni"><br/>
                </form>
            </div>
            @isset($alumnos)
                <ul>
                    @foreach($alumnos as $a)
                        <li>{{$a}}</li>
                    @endforeach
                </ul>
            @endisset
        </div>
    </body>
</html>
