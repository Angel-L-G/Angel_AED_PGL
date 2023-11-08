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
                <form action="createMatr" method="post">
                    <label>Year:</label><input type="text" id="year" name="year"><br/>
                    <label>Dni Alumno:</label><input type="text" id="dni" name="dni"><br/>
                    @foreach($asignaturas as $a)
                        <label>{{$a->getNombre()}}</label>
                        <input type="checkbox" name="asignaturas[]" id="asignaturas[]" value={{$a->getId()}}/><!--Esto funciona-->
                    @endforeach
                    <br/><label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Borrar Matricula</h2>
                <form action="deleteMatr" method="post">
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Editar Matricula</h2>
                <form action="updateMatr" method="post">
                    <label>Year:</label><input type="text" id="year" name="year"><br/>
                    <label>Dni Alumno:</label><input type="text" id="dni" name="dni"><br/>
                    @foreach($asignaturas as $a)
                        <label>{{$a->getNombre()}}</label>
                        <input type="checkbox" name="asignaturas[]" id="asignaturas[]" value={{$a->getId()}}/><!--Esto funciona-->
                    @endforeach
                    <br/>
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
                </form>
            </div>
            <div>
                <h2>Mostrar Matricula</h2>
                <form action="showMatr" method="post">
                    <label>Id:</label><input type="text" id="id" name="id"><br/>
                    <input type="submit" value="enviar">
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
