<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\GestorFichero;
use Illuminate\Support\Facades\Storage;
use App\Models\User;

use function PHPUnit\Framework\isEmpty;

class UserController extends Controller{

    function logIn(Request $request){
        $gf = new GestorFichero();
        $users = $gf->leerFichero();

        if(session()->has("user")){
            if(!isEmpty(session()->has("user"))){
                $ficheros = [];
                return view("Files",compact($ficheros));
            }
        }

        $nick = $request->input("nick");
        $name = $request->input("name");
        $psswrd = $request->input("psswrd");

        $u = new User($nick, $name, $psswrd);

        if(in_array([$nick, $u],$users)){
            session()->put("user",$u);

            $ficheros = [];
            return view("Files",compact($ficheros));
        }

        echo "<script>alert('Error al iniciar sesion')</script>";
        return view("Login");
    }

    function register(Request $request){
        
        $gf = new GestorFichero();
        $users = $gf->leerFichero();

        $name = $request->input("name");
        $nick = $request->input("nick");
        $psswrd = $request->input("psswrd");

        $u = new User($nick, $name, $psswrd);

        if(isset($users[$nick])){
            echo "<script>alert('Usuario ya registrado')</script>";
            return view("Register");

        }
        session()->put("user",$u);

        $newUsers[] = [$nick, $u];

        $gf->guardarFichero($newUsers);

        Storage::makeDirectory("/".$nick , 0755, true);
        
        $ficheros = [];
        return view("Files",compact($ficheros));
    }

    function logOut(){
        session()->flush();
        session()->regenerate();

        return view("Login");
    }
}
