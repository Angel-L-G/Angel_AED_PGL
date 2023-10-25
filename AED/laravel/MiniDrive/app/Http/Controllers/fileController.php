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
        return view('Files',compact('ficheros'));
    }

    function uploadFile(Request $request){
        $file = $request->myfile;
        $nombrefichero = $file->getClientOriginalName();
        $u = session()->get("user");

        $path = $file->storeAs("/".$u->nick."/", $nombrefichero);
        $ficheros = Storage::allFiles("/".$u->nick);
        session()->put("ficheros",$ficheros);

        return view("Files",compact('ficheros'));
    }

    function deleteFile($fich){
        if( Storage::exists($fich)){
            Storage::delete($fich);
        }
    }

    function DownloadFile($fich){
        if( Storage::exists($fich)){
            return response()->download(storage_path($fich));
        }
    }
}
