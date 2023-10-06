<?php
    class AppController{

        public static function index($args){
            require("app/view/Main.php");
            $main = new MainView();
            $main -> head();
            self::loadProducts();
            $main -> loadButtons();
            $main -> foot();
        }

        public static function loadProducts(){
            require("app/model/Product.php");
            $f = "app/model/products.dat";
            $arr = [];

            if(file_exists($f)){
                $sArr = file_get_contents($f);
                $arr = unserialize($sArr);

                for ($i=0; $i < count($arr); $i++) { 
                    echo "<p class='p'>".$arr[$i]."</p>";

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
            require("app/model/Product.php");
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

            $prod = new Product($n, $c, $s, $p, $i);

            $arr[$i] = $prod;

            $sArr = serialize($arr);
            file_put_contents($f,$sArr);

            self::index($args);
        }

        public static function showDelProd($args){
            require("app/view/Main.php");
            require("app/view/DeleteView.php");
            $main = new MainView();
            $secundary = new DeleteView();
            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public static function delProd($args){
            //require("app/model/Product.php");
            $f = "app/model/products.dat";
            $id = $_REQUEST["deleteId"];

            if(file_exists($f)){
                $sArr = file_get_contents($f);
                $arr = unserialize($sArr);
                
                if (isset($arr[$id])){
                    unset($arr[$id]);
                }
                
                $sArr = serialize($arr);
                file_put_contents($f,$sArr);

                self::index($args);
            }


            
        }

        /*public static function fichero($args){
            $f = "app/model/prueba.txt";

            if(file_exists($f)){
                $counter = file_get_contents($f);
                $counter++;
                file_put_contents($f,$counter);
            }else{
                file_put_contents($f,$counter);
            }

            $fp = fopen($f, "rw+");

            if (flock($fp, LOCK_EX)) {  // adquirir un bloqueo exclusivo
                if(filesize($f) == 0){
                    $counter = 0;
                }else{
                    $counter = fread($fp,filesize($f));
                }
                
                $counter = $counter??0;
                $counter++;

                ftruncate($fp, 0);      // truncar el fichero
                rewind($fp);

                fwrite($fp, $counter);
                //fflush($fp);            // volcar la salida antes de liberar el bloqueo
                flock($fp, LOCK_UN);    // libera el bloqueo
            } else {
                echo "¡No se pudo obtener el bloqueo!";
            }

            fclose($fp);

            echo "\n";
            echo $counter;
            echo "\n";
            
        }*/

    }
?>