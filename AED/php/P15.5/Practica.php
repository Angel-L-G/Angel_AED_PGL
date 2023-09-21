<?php
    $array = [];
    $array[2]="mensaje";
    $array[7]="lalala!";
    $array[]="yepa yepa!!";
    var_dump($array);

    echo "<br>";

    $array2 = [2 => "mensaje",7 => "lalala!", "yepa yepa!!"];
    var_dump($array2);
?>