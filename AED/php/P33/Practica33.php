<?php

    $mis_datos = "Ángel Luis García";
    echo "<a href='Practica33.php'?datos=".$mis_datos.">Sin UrlEncode</a>";
    echo "<br>";
    echo "<a href='Practica33.php'?datos=".urldecode($mis_datos).">Con UrlEncode</a>";

    $recibido = $_GET["datos"] ?? "nadita";
    echo "<h3>se ha recibido:</h3>";
    echo "prueba: ". $recibido . "<br>";

    /*echo "<a href=index.php?prueba='Pasando datos diría.. que hay que usar urlencode'>p
    asando datos</a>";
    $recibido = $_GET["prueba"] ?? "nadita";
    echo "<h3>se ha recibido:</h3>";
    echo "prueba: ". $recibido . "<br>";*/
?>