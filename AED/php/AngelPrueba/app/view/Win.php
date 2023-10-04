<?php
    class Win{
        public static function generateWin(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Intento</title>";
            echo "</head>";
            echo "<body>";
                    
            $fileRand = "app/model/Rand.dat";
            $sRandNum = file_get_contents($fileRand);
            $randNum = unserialize($sRandNum);

            echo "<h2>Has Ganado</h2>";
            echo "<p>El numero era: $randNum</p>";

            echo "</body>";
            echo "</html>";
        }
    }
?>

