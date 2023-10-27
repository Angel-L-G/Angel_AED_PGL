<?php
    class FileManager{
        public static function readCSV(){
            $f = "app/model/text.csv";
            if(file_exists($f)){
                $fp = fopen($f, "rw+");

                while(!flock($fp,LOCK_EX)){
                    sleep(0.2);
                }

                if (flock($fp, LOCK_EX)) {  // adquirir un bloqueo exclusivo
                    if(filesize($f) == 0){
                        $arr = [];
                    }else{
                        $arr = fgetcsv($fp);
                        /*
                        $sArr = fread($fp,filesize($f));
                        $arr = unserialize($sArr);*/
                    }
                } else {
                    echo "¡No se pudo obtener el bloqueo!";
                }

                return $arr;
            }
            return null;
        }

        public static function saveCSV($arr){
            $f = "app/model/text.csv";
            $fp = fopen($f, "rw+");

            while(!flock($fp,LOCK_EX)){
                sleep(0.2);
            }

            if (flock($fp, LOCK_EX)) {  // adquirir un bloqueo exclusivo

                ftruncate($fp, 0);      // truncar el fichero
                rewind($fp);

                fputcsv($fp, $arr);

                /*$sArr = serialize($arr);
                fwrite($fp, $sArr);*/

                flock($fp, LOCK_UN);    // libera el bloqueo
            } else {
                echo "¡No se pudo obtener el bloqueo!";
            }

            fclose($fp);
        }
    }
?>