<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use function PHPUnit\Framework\isEmpty;

class UserController extends Controller{
    function P15(){
        return view("Login");
    }

    function showUser(Request $request){
        $prevName = session()->get("name");
        $prevPsswrd = session()->get("psswrd");
        $prevDesc = session()->get("desc");

        $name = $request->input("name");
        $psswrd = $request->input("psswrd");
        $desc = $request->input("desc");

        session()->put("name",$name);
        session()->put("psswrd",$psswrd);
        session()->put("desc",$desc);

        if(!isEmpty($name)){
            session()->put("name",$prevName);
        }

        if(!isEmpty($psswrd)){
            session()->put("psswrd",$prevPsswrd);
        }

        if(!isEmpty($desc)){
            session()->put("desc",$prevDesc);
        }

        return view("User");
    }
}
