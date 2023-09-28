<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Array</title>
</head>
<body>
    <?php
        $f = "prueba.dat";
        $sArr = file_get_contents($f);
        $arr = unserialize($sArr)?? [];

        print_r($arr);
        echo "<br>";

        $name = strtolower($_POST["encuestado"]);
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
        

        file_put_contents($f, $sArr);
    ?>
    <form action="" method="post"></form>
    <input type="submit" value="">
</body>
</html>