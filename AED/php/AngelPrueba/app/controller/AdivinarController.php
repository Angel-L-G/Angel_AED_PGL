<?php
    class AdivinarController{
        public static function index($args){
           
            if(file_exists("app/view/Form.php")){
                require("app/view/Form.php");
                $form = new Form();
                $form -> generateForm();
            }
        }

        public static function mostrarResultados($args){
            if(file_exists("app/view/Result.php")){
                require("app/view/Result.php");
                $res = new Result();
                $res -> generateRes();
            } 
        }

        public static function mostrarNum($args){
            if(file_exists("app/view/Win.php")){
                require("app/view/Win.php");
                $win = new Win();
                $win -> generateWin();
            }
        }
    }
?>