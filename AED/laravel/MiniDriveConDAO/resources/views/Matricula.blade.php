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
                <h2>Agregar Matricula</h2>
                <form action="" method="post">
                    <label>Year:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Dni Alumno:</label><input type="text" id="curso" name="curso"><br/>
                    <!-- Falta los checkbox de las asignaturas -->
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                </form>
            </div>
            <div>
                <h2>Borrar Matricula</h2>
                <form action="" method="post">
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                </form>
            </div>
            <div>
                <h2>Editar Matricula</h2>
                <form action="" method="post">
                    <label>Year:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Dni Alumno:</label><input type="text" id="curso" name="curso"><br/>
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                </form>
            </div>
            <div>
                <h2>Mostrar Matricula</h2>
                <form action="" method="post">
                    <label>Nombre:</label><input type="text" id="nombre" name="nombre"><br/>
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                </form>
            </div>
            @isset($matriculas)
                <ul>
                    @foreach($matriculas as $m)
                        <li>{{$m}}</li>
                    @endforeach
                </ul>
            @endisset
        </div>
    </body>
</html>
