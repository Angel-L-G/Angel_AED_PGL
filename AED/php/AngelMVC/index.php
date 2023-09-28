<?php
    echo "Hola a todos! soy Angel Luis Garcia";
    $url = strtolower($_REQUEST["pathtocontroller"]);
    $urlSplitted = explode("/",$url);
    $urlSplitted[0] = ucfirst($urlSplitted[0])."Controller";
    $nombreClase = $urlSplitted[0];
    echo "<br>";
    $fullUrl = "./app/controller/".$urlSplitted[0].".php";
    echo "Ruta: ".$fullUrl;
    echo "<br/>";
    echo "Clase: ".$nombreClase;
?>