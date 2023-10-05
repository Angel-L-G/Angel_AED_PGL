<?php
    class Form{
        public static function generateForm(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Intento</title>";
            echo "</head>";
            echo "<body>";
                    
                echo "<form action='adivinar/mostrarResultados' method='post'>";
                    echo "<input type='number' name='guess' id='guess' placeholder='Numero a Adivinar'>";
                    //echo "";
                    echo "<input type='submit' value='enviar'>";
                echo "</form>";

                $fileRand = "app/model/Rand.dat";
                $randNum = -1;

                if(file_exists($fileRand)){
                    $randNum = file_get_contents($fileRand);
                    if($randNum == false){
                        $randNum = -1;
                    }
                }                

                if($randNum < 0){
                    $randNum = rand(1,10);
                    
                    file_put_contents($fileRand, $randNum);
                }

            echo "</body>";
            echo "</html>";
        }
    }
?>

