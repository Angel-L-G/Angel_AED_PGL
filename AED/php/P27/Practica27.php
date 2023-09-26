<?php
    $arr = [7,2,8,1,9,4];
    
    $a = array_search(4,$arr);

    print_r($arr);
    echo $a;

    usort($arr, function($a,$b){return $a <=> $b;});

    echo "<br> Despues <br>";

    $a = array_search(4,$arr);

    print_r($arr);
    echo $a;

?>