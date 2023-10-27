<?php
    class TextosController{
        
        public function index($args){
            require_once("app/view/Main.php");
            $main = new MainView();
            $main -> head();
            self::load($args);
            $main -> loadButtons();
            $main -> foot();
        }

        public function load($args){
            require_once("app/model/Anotacion.php");
            require_once("app/model/FileManager.php");

            $fileManager = new FileManager();

            $arr = $fileManager->readCSV();
            
            if(isset($arr)){
                foreach($arr as $key=>$value){
                    if(isset($key)){
                        $fecha = $value->fecha;
                        //$fecha = $fecha;
                        echo "<p class='p'>"
                        .$value
                        /*" Fecha: ". date('Y-m-d H:i:s', $fecha) .*/
                        ."</p>";
                    }
                }
            }else{
                echo "No hay Textos";
            }

        }

        public function crear($args){         
            require_once("app/view/Main.php");
            require_once("app/view/CreateView.php");

            $main = new MainView();
            $secundary = new CreateView();

            $main -> head();
            $secundary -> form();
            $main -> foot();
        }

        public function createText($args){
            require_once("app/model/FileManager.php");
            require_once("app/model/Anotacion.php");

            $fileManager = new FileManager();

            $a = $args["author"];
            $t = $args["titel"];
            $d = $args["desc"];
            
            $arr = $fileManager->readCSV();
            
            if(isset($arr)){
                echo "si set<br>";
                
            }else{
                echo "no set<br>";
                
                $arr = [];
            }

            $fecha = time();
            
            /*$fechaFormateada = date('Y-m-d H:i:s', $fecha);

            echo "fecha actual en unix epoch: $fecha <br>";
            echo "Fecha formateada: $fechaFormateada <br>";

            $unixtimeFromString = strtotime($fechaFormateada);
            echo "pasamos el texto anterior de nuevo a unix epoch: $unixtimeFromString";
            */

            $text = new Anotacion($a,$t,$d,$fecha);

            $arr[] = $text;

            $fileManager->saveCSV($arr);

            header("Location: ../");
        }

    }
?>