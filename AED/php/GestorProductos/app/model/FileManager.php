<?php
    class FileManager{
        public static function readSerialized(string $f){
            
            if(!file_exists($f)){
                $arr = [];
                file_put_contents($f,serialize($arr));
            }

            $fp = fopen($f, "rw+");

            if(filesize($f) == 0){
                $arr = [];
            }else{
                $sArr = fread($fp,filesize($f));
                $arr = unserialize($sArr);
            }

            return $arr;
        }

        public static function saveSerialized(string $f, $arr){
            $fp = fopen($f, "rw+");

            if (flock($fp, LOCK_EX)) {  // adquirir un bloqueo exclusivo

                ftruncate($fp, 0);      // truncar el fichero
                rewind($fp);

                $sArr = serialize($arr);

                fwrite($fp, $sArr);

                flock($fp, LOCK_UN);    // libera el bloqueo
            } else {
                echo "¡No se pudo obtener el bloqueo!";
            }

            fclose($fp);

            
        }
    }
?>