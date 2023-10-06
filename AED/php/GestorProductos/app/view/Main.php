<?php
    class MainView{
        public static function head(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Intento</title>";
                echo "<link rel='stylesheet' src='../css/index.css'/>";
            echo "</head>";
            echo "<body>";
        }

        public static function loadButtons(){
            echo '
            <form action="showCreateProd" method="post">
                <input type="submit" value="Crear">
            </form>';
        }

        public static function foot(){
            echo "</body>";
            echo "</html>";
        }

    }
?>