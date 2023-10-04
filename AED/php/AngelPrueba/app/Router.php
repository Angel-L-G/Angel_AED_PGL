<?php
    class Router{
        private static $defaultcontroller = "adivinar";

        public static function init(){
            $pathArray = self::getUrl();

            $pathArray = $pathArray?? [self::$defaultcontroller];

            $nombreController = $pathArray[0];

            $nombreController = strtolower($nombreController);
            $nombreController = ucfirst($nombreController);
            $nombreController = $nombreController."Controller";

            $method = $pathArray[1]??"index";

            $nombreFicheroController = "app/controller/$nombreController".".php";
            if( !file_exists($nombreFicheroController)){
                echo "ruta no valida";
                die();
            }

            include_once $nombreFicheroController;
            $controller = null;

            if(class_exists($nombreController)){
                $controller = new $nombreController;
            }else{
                echo "clase no valida";
                die();
            }

            $extraPath = "";
            $delimiter = "";
            for ($i=0; $i < count($pathArray); $i++) { 
                $extraPath .= $delimiter.$pathArray[$i];
                $delimiter = "/";
            }
            $methodAllParameters = [$extraPath];


            foreach ($_REQUEST as $key => $value) {
                if($key != "pathtocontroller"){
                    $methodAllParameters[$key] = $value;
                }
            }

            call_user_func_array([$controller, $method], ["args"=>$methodAllParameters]);

        }

        public static function getUrl(){
            if(isset($_REQUEST['pathtocontroller'])){
                $path = rtrim($_REQUEST['pathtocontroller']);
                $path = filter_var($path, FILTER_SANITIZE_URL);
                $pathArray = explode("/",$path);

                return $pathArray;
            }
        }
    }
?>