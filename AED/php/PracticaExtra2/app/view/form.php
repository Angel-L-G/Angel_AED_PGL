<?php
    class Form{
        public function generateForm(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Principal</title>";
            echo "</head>";
            echo "<body>";
                
                echo "<form action='vista' method='post'>";
                    echo "<input type='text placeholder='Nombre encuestado' id='encuestado' name='encuestado' >";
                    echo "<br>";
                        require("app/model/fichero_array_nombres.php");

                        foreach ($arrNom as $key => $value) {
                            echo "<label>$value</label>";
                            echo "<br>";
                            echo "<input type='number' name='$key' id='$key'/>";
                            echo "<br>";
                        }

                    
                    echo "<input type='submit' value='enviar'>";
                echo "</form>";
            echo "</body>";
            echo "</html>";
        }
    }
?>
