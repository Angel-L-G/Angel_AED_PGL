<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Validación</title>
</head>
<body>
    <h1>Formulario de Validación</h1>
    <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre">
        <br>

        <label for="correo">Correo:</label>
        <input type="text" name="correo" id="correo">
        <br>

        <label for="genero">Género:</label>
        <select name="genero" id="genero">
            <option value="">Seleccione un género</option>
            <option value="masculino">Masculino</option>
            <option value="femenino">Femenino</option>
        </select>
        <br>

        <input type="submit" value="Enviar">
    </form>

    <?php
        $nombre = $_POST["nombre"];
        $correo = $_POST["correo"];
        $genero = $_POST["genero"];
        $errores = [];

        if (empty($nombre)) {
            $errores[] = "Nombre es obligatorio.";
        }

        if (empty($genero)) {
            $errores[] = "Género es obligatorio.";
        }

        if (!filter_var($correo, FILTER_VALIDATE_EMAIL)) {
            $errores[] = "Correo no válido.";
        }

        if (empty($errores)) {
            echo "<h2>Datos ingresados:</h2>";
            echo "Nombre: " . htmlspecialchars($nombre) . "<br>";
            echo "Correo: " . htmlspecialchars($correo) . "<br>";
            echo "Género: " . htmlspecialchars($genero) . "<br>";
        } else {
            echo "<h2 style='color: red;'>Errores:</h2>";
            foreach ($errores as $error) {
                echo "<p style='color: red;'>" . $error . "</p>";
            }
        }
    ?>
</body>
</html>