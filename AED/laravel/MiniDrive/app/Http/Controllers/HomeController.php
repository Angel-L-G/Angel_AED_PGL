<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Contracts\Support\Renderable
     */
    //public function index(){

    //}

    public static function show(Request $request){
        $arrColors = session()->get("arrColors");
        print_r($arrColors);
        if(!(isset($arrColors)) && $arrColors == null){
            echo "bbbbbbbb";
            $arrColors = [];
        }else{
            echo "aaaaaaaaaa";
            $color = $request->input("color");
            array_push($arrColors,$color);
        }
        session()->put("arrColors",$arrColors);

        return view("colorView",compact($arrColors));
    }
}
