<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HoraController extends Controller{
    public function showHora(){
        //$date = ;
        //$arr[0] = $date;
        return view('hora');
    }

    public function horaFromBefore(){
        //$date = ;
        //$arr[0] = $date;
        return view('sleep');
    }
}

