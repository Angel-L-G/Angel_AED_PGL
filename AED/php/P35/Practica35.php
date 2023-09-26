<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla</title>
</head>
<body>
    <!--  -->
    <form action="<?php echo $_SERVER['SCRIPT_NAME'] ?>" method="post">
        <input type="number">
        <input type="submit" value="enviar">  
    </form>
    <?php
        
        if (isset($_POST['enviar']) && is_int($_POST['tabla'])){
            $tabla = $_POST['tabla'];
            echo "$tabla";
            $res = "";
            for ($i=0; $i <= 10; $i++) { 
                $res += "$tabla * $i = " + $tabla*$i;
            }
        }
    ?>    
</body>
</html>
