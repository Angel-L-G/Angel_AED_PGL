<?php
    /*echo "<a href=index.php?prueba='Pasando datos diría.. que hay que usar urlencode'>p
    asando datos</a>";
    $conUrlEncode = urlencode('Pasando datos diría.. que hay que usar urlencode');
    $recibido = $_GET["prueba"] ?? "nadita";
    echo "<h3>se ha recibido:</h3>";
    echo "prueba: ". $recibido . "<br>";*/

    $conUrlEncode = urlencode('Pasando datos diría.. que hay que usar urlencode');
    echo "<a href=index.php?prueba=$conUrlEncode>p
    asando datos</a>";
    $recibido = $_GET["prueba"] ?? "nadita";
    echo "<h3>se ha recibido:</h3>";
    echo "prueba: ". $recibido . "<br>";
?>