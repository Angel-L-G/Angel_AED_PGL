<?php
    class FileManager{
        public static function readSerialized(string $f){
            $sArr = file_get_contents($f);
            $arr = unserialize($sArr);

            return $arr;
        }

        public static function saveSerialized(string $f, $arr){
            $sArr = serialize($arr);
            file_put_contents($f,$sArr);
        }
    }
?>