<?php
    class MainView{
        public static function head(){
            echo "<!DOCTYPE html>";
            echo "<html lang='en'>";
            echo "<head>";
                echo "<meta charset='UTF-8'>";
                echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
                echo "<title>Intento</title>";
                echo '<link rel="stylesheet" href="css/index.css" />';
            echo "</head>";
            echo "<body>";
                echo "<div class='container'>";
        }

        public static function loadButtons(){
            echo '
            <form action="app/showCreateProd" method="post">
                <input type="submit" value="Crear" class="button">
            </form>
            <form action="app/showDelProd" method="post">
                <input type="submit" value="Eliminar" class="button">
            </form>
            <form action="app/showModProd" method="post">
                <input type="submit" value="modificar" class="button">
            </form>';
        }

        public static function foot(){
                echo "</div>";
            echo "</body>";
            echo "</html>";
        }

    }
?>