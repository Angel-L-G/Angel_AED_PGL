<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\DAO\MatriculaDAO;

class MatriculaController extends Controller{
    public function index(){
        //if()
        $pdo = DB::getPdo();
        $matriculaDAO = new MatriculaDAO($pdo);

        $matriculas = $matriculaDAO->findAll();

        return view("Principal",compact("matriculas"));
    }
}
