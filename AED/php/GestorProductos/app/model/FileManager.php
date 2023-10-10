<?php
    class FileManager{
        public static function readSerialized(string $f){
            $fp = fopen($f, "rw+");

            while(!flock($fp,LOCK_EX)){
                sleep(0.2);
            }

            if (flock($fp, LOCK_EX)) {  // adquirir un bloqueo exclusivo
                if(filesize($f) == 0){
                    $arr = [];
                }else{
                    $sArr = fread($fp,filesize($f));
                    $arr = unserialize($sArr);
                }
            } else {
                echo "¡No se pudo obtener el bloqueo!";
            }

            return $arr;
        }

        public static function saveSerialized(string $f, $arr){
            $fp = fopen($f, "rw+");

            while(!flock($fp,LOCK_EX)){
                sleep(0.2);
            }

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