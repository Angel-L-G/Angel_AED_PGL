<?php
    class ParejasController{
        public static function index($args){
            if(file_exists("app/view/Parejas.php")){
                require("app/view/Parejas.php");
                $parejas = new Parejas();
                $parejas->generateParejas();
            }
        }
    }
?>