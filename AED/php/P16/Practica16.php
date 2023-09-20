<?php
    $array = array('perro', 'gato', 'avestruz');
    foreach ($array as $key => $val) {
        print "<br>array[ $key ] = $val";
    }

    $array = array('perro', 'gato', 'avestruz');
    foreach ($array as $i => $j) {
        print "<br>array[ $i ] = $j";
    }

    //Funcionan los dos
?>