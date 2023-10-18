<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

/**
 * @var array $arr Should contain some numbers
 */
class ControladorNumeros extends Controller{
    public function generar(){
        $arr = [];
        for ($i=0; $i < 30; $i++) {
            $arr[$i] = random_int(0,100);
        }
        
        return view("nums",compact('arr'));
    }
}
