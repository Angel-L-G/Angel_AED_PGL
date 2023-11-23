<?php

namespace App\Http\Controllers;

use App\DAO\UserDAO;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\User;

class UserController extends Controller
{
    public function register(Request $request){
        $pdo = DB::getPdo();
        $userDAO = new UserDAO($pdo);

        $id = request()->get("id");
        $nick = request()->get("name");
        $psswrdNoHash = request()->get("psswrd");

        $users = $userDAO->findAll();
        $continue = true;

        //print_r($users);
        foreach ($users as $key => $value) {
            if($nick == $value->getNick()){
                $continue = false;
            }
        }

        if($continue){
            $u = new User();
            $u->setNick($nick);
            $nuevaClave = password_hash($psswrdNoHash,PASSWORD_BCRYPT );
            $u->setPassword($nuevaClave);
            $u->setId($id);
            $res = $userDAO->save($u);
            session()->put("user",$u);
            return view("principal");
        }else{
            echo "<script>alert('Ha Habido Un Error')</script>";
            return view("Register");
        }
    }
    
    public function logIn(Request $request){
        $pdo = DB::getPdo();
        $userDAO = new UserDAO($pdo);

        $id = request()->get("id");
        $nick = request()->get("name");
        $psswrdNoHash = request()->get("psswrd");

        $users = $userDAO->findAll();
        $continue = false;

        $u = $userDAO->findById($id);

        if($u != null){
            if(password_verify($psswrdNoHash, $u->getPassword()) && $nick == $u->getNick()){
                session()->put("user",$u);
                return view("Principal");
            }
        }else{
            return view("Login");
        }

        /*foreach ($users as $key => $value) {
            if(password_verify($psswrdNoHash, $value->getPassword()) && $nick == $value->getNick()){
                $continue = true;
            }
        }
        
        if($continue){
            return view("principal");
        }else{
            echo "<script>alert('Ha Habido Un Error')</script>";
            return view("Register");
        }*/
    }
}
