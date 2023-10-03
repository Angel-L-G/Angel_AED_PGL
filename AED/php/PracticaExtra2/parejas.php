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

        foreach ($arr as $nomAl1 => $arrAl1) {
            $idAl1 = array_search($nomAl1,$arrNom);
            $soloCounter = 0;
            foreach ($arrAl1 as $nomAl2 => $puntos) {
                if($puntos != 0 && isset($arr[$nomAl2])){
                    $soloCounter++;
                    $idAl2 = array_search($nomAl2, $arrNom);
                    $arrAl2 = $arr[$nomAl2];
                    $sum = $puntos + $arrAl2[$nomAl1];
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
        //print_r($arrDual);

        foreach ($arrDual as $idConcat => $puntos) {
            $ids = explode("-",$idConcat);
            $idAl1 = $ids[0];
            $idAl2 = $ids[1];
            $aux;
            /*echo $idAl1 < $idAl2;
            echo "<br>";
            echo $idAl1;
            echo "<br>";
            echo $idAl2;
            echo "<br>";*/
            //echo "id1: " . $idAl1 . " id2: " . $idAl2 . "<br>";
            if($idAl1 < $idAl2){
                //Pareja
                $aux2;
                $aux = array_search($idAl1,$idUsadas) ?? -1;
                $aux2 = array_search($idAl2,$idUsadas) ?? -1;
                echo $aux;
                echo "<br>";
                print_r($idUsadas);
                echo "<br>";
                // Problema aqui con las parejas el ultimo no se pone 
                // y se repite el primero por el &&
                if($aux <= 0 && $aux2 <= 0){
                    $nomConcat = $arrNom[$idAl1] . "-" . $arrNom[$idAl2];
                    $parejas[$idConcat] = $nomConcat;
                    array_push($idUsadas,$idAl1);
                    array_push($idUsadas,$idAl2);
                }
            }else if($idAl1 == $idAl2){
                //Solo
                $aux = array_search($idAl1,$idUsadas) ?? -1;
                if($aux <= 0){
                    $parejas[$idAl1] = $arrNom[$idAl1] . " esta solo solito";
                    array_push($idUsadas,$idAl1);
                }
            }
        }
        echo "<br><br><br>";
        print_r($parejas);
        echo "<br><br><br>";
        print_r($idUsadas);

/*
        julio [
                a 1
                b 2
                c 3
            ] 
            
            
        a [
            b 4 
            c 1
            julio 9
           ]
*/


    ?>
    
</body>
</html>