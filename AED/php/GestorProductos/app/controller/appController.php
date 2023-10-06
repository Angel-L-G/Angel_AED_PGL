<?php
    class appController{

        public static function index($args){
            require("app/view/Main.php");
            $main = new MainView();
            $main -> head();
            self::loadProducts();
            $main -> loadButtons();
            $main -> foot();
        }

        public static function loadProducts(){
            $f = "app/model/products.dat";
            $arr = [];

            if(file_exists($f)){
                $sArr = file_get_contents($f);
                $arr = unserialize($sArr);

                for ($i=0; $i < count($arr); $i++) { 
                    echo "<p>".$arr[$i]."</p>";

                }
            }else{
                echo "No hay productos";
            }
        }

        public static function showCreateProd($args){
            require("app/view/Main.php");
            require("app/view/CreateView.php");
            $main = new MainView();
            $secundary = new CreateView();
            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public static function createProd($args){
            $n = $_REQUEST["name"];
            $c = $_REQUEST["category"];
            $s = $_REQUEST["stock"];
            $p = $_REQUEST["price"];

            $f = "app/model/products.dat";
            if(file_exists($f)){
                $sArr = file_get_contents($f);
                $arr = unserialize($sArr);
                $i = count($arr);
            }else{
                $i = 0;
            }

            require("app/model/Product.php");
            $prod = new Product($n, $c, $s, $p, $i);

            $arr[$i] = $prod;

            $sArr = serialize($arr);
            file_put_contents($f,$sArr);

            self::index($args);
        }

        public static function showDelProd(){
            require("app/view/Main.php");
            require("app/view/DeleteView.php");
            $main = new MainView();
            //$secundary = new DeleteView();
            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public static function delProd(){

        }

    }
?>