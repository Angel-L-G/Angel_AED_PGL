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
        require("../model/fichero_array_nombres.php");
        $f = "../model/prueba.dat";
        $sArr = file_get_contents($f);
        $arr = unserialize($sArr)?? [];
        $arrDual = [];

        //print_r($arr);

        foreach ($arr as $nomAl1 => $arrAl1) {
            $idAl1 = array_search($nomAl1,$arrNom);
            $soloCounter = 0;
            foreach ($arrAl1 as $nomAl2 => $puntos) {
                if($puntos != 0 && isset($arr[$nomAl2])){
                    $soloCounter++;
                    $idAl2 = array_search($nomAl2, $arrNom);
                    $arrAl2 = $arr[$nomAl2];
                    $sum = $puntos + ($arrAl2[$nomAl1]??0);
                    $idConcat = $idAl1."-".$idAl2;
                    $arrDual[$idConcat] = $sum;   
                    //echo $idAl2."<br>"; 
                }
            }

            if($soloCounter == 0){
                $sum = 1000;
                $idConcat = $idAl1."-".$idAl1;
                $arrDual[$idConcat] = $sum; 
            }
        }

        arsort($arrDual);
        $idUsadas = [];
        $parejas = [];

        foreach ($arrDual as $idConcat => $puntos) {
            $ids = explode("-",$idConcat);
            $idAl1 = $ids[0];
            $idAl2 = $ids[1];
            $aux;

            if($idAl1 < $idAl2){
                
                //Pareja
                $aux2;
                $aux = $idUsadas[$idAl1]??-1;
                $aux2 = $idUsadas[$idAl2]??-1;
                
                if((!isset($aux) || $aux < 0 )&& (!isset($aux2) || $aux2 < 0)){

                    $nomConcat = $arrNom[$idAl1] . "-" . $arrNom[$idAl2];
                   
                    $parejas[$idConcat] = $nomConcat;
                   
                    $idUsadas[$idAl1] = 1000;
                    $idUsadas[$idAl2] = 1000;
                }
            }else if($idAl1 == $idAl2){
                //Solo

                $aux = $idUsadas[$idAl1]??-1;
                if($aux < 0){
                    
                    $parejas[$idAl1] = $arrNom[$idAl1] . " Decidio estar solo solito";
                    $idUsadas[$idAl1] = 1000;
                }
            }else if(count($arr)-1 == count($idUsadas)){

                $aux = $idUsadas[$idAl1]??-1;
                if($aux < 0){

                    $parejas[$idAl1] = $arrNom[$idAl1] . " Le toco estar solo solito";
                    $idUsadas[$idAl1] = 1000;
                }
            }
        }
        //echo "<br><br><br>";
        print_r($parejas);
        echo "<br><br><br>";
        print_r($idUsadas);
    ?>
    
</body>
</html>