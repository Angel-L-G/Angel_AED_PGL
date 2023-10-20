<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Controllers\GestorFichero;

use function PHPUnit\Framework\isEmpty;

class UserController extends Controller{
    function showRegister(){
        return view("Register");
    }

    function showLogin(){
        return view("Login");
    }

    function logIn(Request $request){
        $gf = new GestorFichero();
        $user = $gf->leerFichero();

        if(session()->has("name") && session()->has("psswrd")){
            if(!isEmpty(session()->get("name")) && !isEmpty(session()->get("psswrd"))){
                return view("User");
            }
        }

        $name = $request->input("name");
        $psswrd = $request->input("psswrd");

        foreach ($user as $key => $value) {
            if(in_array([$name, $psswrd],$user)){
                session()->put("name",$name);
                session()->put("psswrd",$psswrd);

                return view("User");
            }
        }

        return view("Login");
    }

    function register(Request $request){
        $users = session()->get("users") ?? [];
        $name = $request->input("name");
        $psswrd = $request->input("psswrd");

        session()->put("name",$name);
        session()->put("psswrd",$psswrd);
        $users[] = [$name, $psswrd];

        $gf = new GestorFichero();

        $gf->guardarFichero($users);

        return view("User");
    }

    function logOut(){
        session()->forget("name");
        session()->forget("passwrd");

        return view("Login");
    }
}
