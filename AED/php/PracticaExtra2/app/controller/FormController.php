<?php
    class FormController{
        public static function index($args){
            if(file_exists("app/view/form.php")){
                require("app/view/form.php");
                $form = new Form();
                $form->generateForm();
            }
        }
    }
?>