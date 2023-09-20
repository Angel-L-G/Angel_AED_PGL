<?php
    $array = [];

    for ($i=0; $i < 10; $i++) { 
        array_push($array,$i);
        print_r($array);
        echo "</br>";
    }

    echo "</br>aaaaaaaaaaaaaaaaaaaa</br>";

    for ($i=0; $i < 5; $i++) { 
        array_pop($array);
        print_r($array);
        echo "</br>";
    }

    echo "</br>bbbbbbbbbbbbbbbbbbb</br>";
?>