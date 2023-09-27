<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parejas</title>
</head>
<body>
    <h1>Parejas: </h1>
    <?php
        require("fichero_array_nombres.php");
        $f = "prueba.dat";
        $sArr = file_get_contents($f);
        $arr = unserialize($sArr)?? [];
        

        foreach ($arrNom as $idAl1 => $nombreAl1) {
            
        }
    ?>
</body>
</html>