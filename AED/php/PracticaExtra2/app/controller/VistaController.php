<?php
    class VistaController{
        public static function index($args){
            if(file_exists("app/view/SecondFile.php")){
                require("app/view/SecondFile.php");
                $vista = new Vista();
                $vista->generateVista();
            }
        }
    }
?>