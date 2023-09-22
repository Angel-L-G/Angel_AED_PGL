<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="SecondFile.php" method="post">
        <?php
            $arrayNombres = ["Nathan", "Saul", "Joao", "JavMarcego", "PatricioEstrellado", "Autista(Julio)", 
                "inglaterrense(owen)", "po-po-po-poyben(Ruben)", "nauzet", "yoel", "Moi", "alberto", "cristian", "yo"];

            foreach ($arrayNombres as $key => $value) {
                echo "<input type='number' name='$value' id='$value' placeholder='$value'/>";
                echo "<br>";
            }

            //$_POST["nombre"];
        ?>
        <input type="submit" value="enviar">
    </form>
</body>
</html>
