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

        if(in_array([$u],$users)){
            session()->put("User",$u);

            $ficheros = [];
            return redirect()->action([FileController::class, 'showFiles']);
        }

        echo "<script>alert('Error al iniciar sesion')</script>";
        return view("Login");
    }

    function reConstruct(Array $arr){
        $usersBuilt = [];
        foreach ($arr as $userArray) {
            $datos = explode(";", $userArray[0]);
            $u = new User($datos[0], $datos[1], $datos[2]);
            $usersBuilt[$datos[0]] = $u; 
        }
        return $usersBuilt;
    }

    function register(Request $request){
        $gf = new GestorFichero();
        $users = $gf->leerFichero();

        $users = self::reConstruct($users);

        $name = $request->input("name");
        $nick = $request->input("nick");
        $psswrd = $request->input("psswrd");

        $u = new User($nick, $name, $psswrd);

        if(isset($users[$nick])){
            echo "<script>alert('Usuario ya registrado')</script>";
            return view("Register");

        }
        session()->put("user",$u);

        $newUsers[$nick] = [$u];

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
