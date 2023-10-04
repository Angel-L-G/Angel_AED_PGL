<?php
    class Parejas{
        public function generateParejas(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Principal</title>";
            echo "</head>";
            echo "<body>";
                echo "<h1>Parejas: </h1>";
                require("app/model/fichero_array_nombres.php");
                $f = "app/model/prueba.dat";
                $sArr = file_get_contents($f);
                $arr = unserialize($sArr)?? [];
                $arrDual = [];

                //print_r($arr);

                foreach ($arr as $nomAl1 => $arrAl1) {
                    $idAl1 = array_search($nomAl1,$arrNom);
                    $soloCounter = 0;
                    foreach ($arrAl1 as $nomAl2 => $puntos) {
                        if($puntos != 0 && isset($arr[$nomAl2])){
                            $puntos = strval($puntos);
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
                        //echo "<br>pareja ";
                        $aux2;
                        $aux = $idUsadas[$idAl1]??-1;
                        $aux2 = $idUsadas[$idAl2]??-1;
                        
                        if((!isset($aux) || $aux < 0 ) && (!isset($aux2) || $aux2 < 0)){
                            //echo "Hecho";
                            $nomConcat = $arrNom[$idAl1] . "-" . $arrNom[$idAl2];
                        
                            $parejas[$idConcat] = $nomConcat;
                        
                            $idUsadas[$idAl1] = 1000;
                            $idUsadas[$idAl2] = 1000;
                        }
                    }else if(($idAl1 == $idAl2) || count($arr)-1 == count($idUsadas)){
                        //Solo
                        //echo "<br>solo decision ";
                        $aux = $idUsadas[$idAl1]??-1;
                        if($aux < 0){
                            //echo "Hecho";
                            $parejas[$idAl1] = $arrNom[$idAl1] . " Decidio estar solo solito";
                            $idUsadas[$idAl1] = 1000;
                        }
                    }/*else if(count($arr)-1 == count($idUsadas)){
                        //echo "<br>solo ";
                        $aux = $idUsadas[$idAl1]??-1;
                        if($aux < 0){
                            //echo "Hecho";
                            $parejas[$idAl1] = $arrNom[$idAl1] . " Le toco estar solo solito";
                            $idUsadas[$idAl1] = 1000;
                        }
                    }*/
                }
                //echo "<br><br><br>";
                print_r($parejas);
                echo "<br><br><br>";
                print_r($idUsadas);

            echo "</body>";
            echo "</html>";
        }
    }
?>