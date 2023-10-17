<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ControladorNumeros extends Controller{
    public function generar(){
        $arr = [];
        for ($i=0; $i < 30; $i++) {
            $arr[$i] = random_int(0,100);
        }

        return view("nums",compact('arr'));
    }
}
