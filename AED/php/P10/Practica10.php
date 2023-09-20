<?php
    $numero = 472;
    $numeroInicial = $numero;
    $descomposicion = '';
    $potencia = 1;

    while ($numero > 0) {
        $digito = $numero % 10;
        $descomposicion .= "$digito * $potencia";
        $potencia *= 10;

        if ($numero >= 10) {
        $descomposicion .= " + ";
        }

        $numero = (int)($numero / 10);
    }

    echo "Descomposición: $descomposicion\n";
    echo "Resultado: $numeroInicial";
?>