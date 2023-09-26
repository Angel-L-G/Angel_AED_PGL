<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <form action="SecondFile.php" method="post">
        <input type="text" placeholder="Nombre encuestado" id="encuestado" name="encuestado" >
        <br>
        <?php
            require("fichero_array_nombres.php");

            foreach ($arrNom as $key => $value) {
                echo "<label>$value</label>";
                echo "<br>";
                echo "<input type='number' name='$key' id='$key'/>";
                echo "<br>";
            }

        ?>
        <input type="submit" value="enviar">
    </form>
</body>
</html>
