<?php
    $num = 12345;
    $res = "";

    for ($i=0; $i < $num; $i*=10) { 
        //$digit = $num  10;

        $res .= $digit . ":" . $i . "</br>";
    }
    echo $res;
?>