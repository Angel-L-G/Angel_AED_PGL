<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php

        $sArr = file_get_contents('prueba.dad');
        $arr = unserialize($sArr)?? [];

        print_r($arr);
        echo "<br>";

        $name = $_POST["encuestado"];
        require("fichero_array_nombres.php");
        $puntos = [];

        foreach ($arrNom as $key => $value) {
            if(strtolower($value) != strtolower($name)){
                $punto = $_POST[$key];
                $puntos[$value] = $punto;
            }
        }

        $arr[$name] = $puntos;

        print_r($arr);
        
        $sArr = serialize($arr);
        $f = "prueba.dad";

        file_put_contents($f, $sArr);
    ?>
</body>
</html>