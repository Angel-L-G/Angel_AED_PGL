<?php
    $array = [];
    for ($i=0; $i < 10; $i++) { 
        $array[$i] = rand(20,25);
        
    }

    print_r($array);

    echo "<br>";

    $res = array_search(22,$array);

    echo $res;
?>