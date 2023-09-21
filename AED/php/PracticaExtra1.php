<?php
    
    function cmp($a, $b){
        return $a <=> $b;
    }

    $array = [];
    for ($i=0; $i < rand(10,20); $i++) { 
        $array[$i] = rand(1,20);
    }

    print_r($array);
    echo "<br>";
    $res = [];


    for ($i=0; $i < count($array); $i++) {
        $num = $array[$i];
        $counter = 0;
        for ($j=0; $j < count($array); $j++) { 
            if($num == $array[$j]){
                $counter++;
            }
        }

        $res[$num] = $counter;
        echo $num;
        echo "<br>";
    }
    usort($res, "cmp");

    echo "<br>";

    print_r($res);
?>