<?php
    class AppController{

        public static function index($args){
            require_once("app/view/Main.php");
            $main = new MainView();
            $main -> head();
            self::loadProducts($args);
            $main -> loadButtons();
            $main -> foot();
        }

        public static function loadProducts($args){
            require_once("app/model/Product.php");
            require_once("app/model/FileManager.php");

            $fileManager = new FileManager();

            $f = "app/model/products.dat";
            $arr = [];

            if(file_exists($f)){
                $arr = $fileManager->readSerialized($f);
                foreach ($arr as $key => $value) {
                    if(isset($key)){
                        echo "<p class='p'>".$value."</p>";
                    }
                }
            }else{
                echo "No hay productos";
            }
        }

        public static function showCreateProd($args){
            require_once("app/view/Main.php");
            require_once("app/view/CreateView.php");
            $main = new MainView();
            $secundary = new CreateView();
            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public static function createProd($args){
            require_once("app/model/Product.php");
            require_once("app/model/FileManager.php");

            $fileManager = new FileManager();

            $n = $_REQUEST["name"];
            $c = $_REQUEST["category"];
            $s = $_REQUEST["stock"];
            $p = $_REQUEST["price"];

            $f = "app/model/products.dat";
            if(file_exists($f)){
                $arr = $fileManager->readSerialized($f)??[]; 
                //if(filesize($f) == 0){
                    $i = end($arr)->id+1;
                //}
            }else{
                $i = 0;
            }

            $prod = new Product($n, $c, $s, $p, $i);

            $arr[$i] = $prod;

            $fileManager->saveSerialized($f, $arr);

            header("Location: ../");
            //header("Location: /practicas/GestorProductos/");
            //self::index($args);
        }

        public static function showDelProd($args){
            require_once("app/view/Main.php");
            require_once("app/view/DeleteView.php");
            $main = new MainView();
            $secundary = new DeleteView();
            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public static function delProd($args){
            require_once("app/model/Product.php");
            require_once("app/model/FileManager.php");

            $fileManager = new FileManager();
            $f = "app/model/products.dat";
            $id = $_REQUEST["id"];

            if(file_exists($f)){
                $arr = $fileManager->readSerialized($f);
                
                if (isset($arr[$id])){
                    unset($arr[$id]);
                }
                
                $fileManager->saveSerialized($f, $arr);

                header("Location: ../");
                //header("Location: /practicas/GestorProductos");
                //self::index($args);
            }  
        }

        public static function showModProd($args){
            require_once("app/view/Main.php");
            require_once("app/view/ModifyView.php");
            $main = new MainView();
            $secundary = new ModifyView();
            $main -> head();
            $secundary -> form();
            self::loadProducts($args);
            $main -> foot();
        }

        public static function ModProd($args){
            self::delProd($args);

            self::createProd($args);
        }

        /*
        public function filtrar($args) {
            $filtro = $args["filtro"];
            $array = [];

            foreach (self::$productos as $key => $value) {
                if (strpos($value["nombre"], $filtro)) {
                    $array[] = $value;
                }
            }

            if (file_exists('app/view/Listar.php')) {
                require_once('app/view/Listar.php');
                require_once('app/view/Main.php');
                $vista = new MainView();
                $vistaListar = new ListarView();
                $vista->head();
                $vistaListar->listar($array);
                $vista->foot();
            } else {
                echo "el fichero no existe";
            }
        }*/
    }
?>