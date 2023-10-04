<?php
    class Vista{
        public function generateVista(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Principal</title>";
            echo "</head>";
            echo "<body>";

            $f = "app/model/prueba.dat";
            $sArr = file_get_contents($f);
            $arr = unserialize($sArr)?? [];

            print_r($arr);
            echo "<br>";

            $name = strtolower($_POST["encuestado"]);
            require("app/model/fichero_array_nombres.php");
            $puntos = [];

            foreach ($arrNom as $key => $value) {
                if(strtolower($value) != strtolower($name)){
                    $punto = $_POST[$key];
                    $puntos[$value] = $punto;
                }
            }
    
            $arr[$name] = $puntos;

            print_r($arr);
            
            $sArr = serialize($arr);
            

            file_put_contents($f, $sArr);
    
            echo "<form action='parejas' method='post'>";
                echo "<input type='submit' value='enviar'>";
            echo "</form>";
            echo "</body>";
            echo "</html>";
        }
    }
?>