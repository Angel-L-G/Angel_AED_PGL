<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class GestorFichero extends Controller {
    function leerFichero(){
        $nombrefichero = "users.csv";
        //if (($open = fopen(storage_path() . "\\".$nombrefichero, "r")) !== FALSE) {
            if (($open = fopen(storage_path() . "/".$nombrefichero, "r")) !== FALSE) {
            $contenido = [];
            while (($data = fgetcsv($open, 1000, ",")) !== FALSE) {
                $contenido[] = $data;
            }
            fclose($open);
            return $contenido;
        }
        return null;
    }

    function guardarFichero(Array $arr){
        $nombrefichero = "users.csv";
        //if (($open = fopen(storage_path() . "\\".$nombrefichero, "a")) !== FALSE) {
            if (($open = fopen(storage_path() . "/".$nombrefichero, "a")) !== FALSE) {
            //$open = fopen(storage_path() . "\\".$nombrefichero, "a");
            $open = fopen(storage_path() . "/".$nombrefichero, "a");

            foreach ($arr as $value) {
                fputcsv($open, $value);
            }
        }
    }
}
