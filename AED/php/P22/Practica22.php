<?php
    $arr= ["1","2","3","4"];
    $va = array_unshift($arr, "7", "8");
    echo "el array ahora queda: <br>";
    print_r($arr);

    echo "<br>";
    echo "<br>";
    echo "<br>";
    echo "<br>";

    $arr= ["1","2","3","4"];
    $va = array_shift($arr);
    echo "el array ahora queda: <br>";
    print_r($arr);
    echo "<br>el valor extraido es: " . $va;
?>