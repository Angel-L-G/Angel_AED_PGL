<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class fileController extends Controller{
    function showFiles(){
        $user = session()->get("User");
        $nick = $user->nick;
        $ficheros = Storage::allFiles("/".$nick);
        return view('Home',compact('ficheros'));
    }
}
