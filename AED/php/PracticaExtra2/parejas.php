<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parejas</title>
</head>
<body>
    <h1>Parejas: </h1>
    <?php
        require("fichero_array_nombres.php");
        $f = "prueba.dat";
        $sArr = file_get_contents($f);
        $arr = unserialize($sArr)?? [];
        $arrDual = [];
        $idUsada = [];
        $parejas = [];

        foreach ($arr as $nomAl1 => $arrAl1) {
            $idAl1 = array_search($arrNom,$nomAl1);
            $soloCounter = 0;
            foreach ($arrAl1 as $nomAl2 => $puntos) {
                if($puntos != 0){
                    $soloCounter++;
                    $idAl2 = array_search($arrNom,$nomAl2);
                    $arrAl2 = $arr[$nomAl2];
                    $sum = $puntos + $arrAl2[$nomAl1];
                    $idConcat = $idAl1."-".$idAl2;
                    $arrDual[$idConcat] = $sum;    
                }
            }

            if($soloCounter == 0){
                $sum = 100;
                $idConcat = $idAl1."-".$idAl1;
                $arrDual[$idConcat] = $sum; 
            }
        }

        arsort($arrDual);

        foreach ($arrDual as $idConcat => $puntos) {
            $ids = explode("-",$idConcat);
            $idAl1 = $ids[0];
            $idAl2 = $ids[1];
            if($idAl1 <=> $idAl2 = 1){
                //Pareja

            }else if($idAl1 <=> $idAl2 = 0){
                //Solo

            }
            

        }
    ?>
</body>
</html>