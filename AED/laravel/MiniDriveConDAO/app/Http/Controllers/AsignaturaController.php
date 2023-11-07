<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Asignatura;
use App\DAO\AsignaturaDAO;
use Illuminate\Support\Facades\DB;

class AsignaturaController extends Controller
{
    public function create(Request $request){
        $nombre = request()->get("nombre");
        $curso = request()->get("curso");
        $id = request()->get("id");

        $a = new Asignatura();

        $a->setNombre($nombre);
        $a->setCurso($curso);
        $a->setId($id);

        $pdo = DB::getPdo();
        $asignaturaDAO = new AsignaturaDAO($pdo);

        $res = $asignaturaDAO->save($a);

        if($res == null){
            echo "Algo salio mal";
        }

        return view("Principal");
    }

    public function delete(Request $request){
        $pdo = DB::getPdo();
        $asignaturaDAO = new AsignaturaDAO($pdo);

        $id = request()->get("id");
        $bool = $asignaturaDAO->delete($id);

        if($bool == true){
            echo "Algo salio mal";
        }

        return view("Principal");
    }

    public function update(Request $request){
        $id = request()->get("id");

        $pdo = DB::getPdo();
        $asignaturaDAO = new AsignaturaDAO($pdo);

        $bool = $asignaturaDAO->delete($id);

        if($bool == true){
            echo "Algo salio mal";
        }else{
            $nombre = request()->get("nombre");
            $curso = request()->get("curso");

            $a = new Asignatura();

            $a->setNombre($nombre);
            $a->setCurso($curso);
            $a->setId($id);

            $res = $asignaturaDAO->save($a);

            if($res == null){
                echo "Algo salio mal";
            }
        }

        return view("Principal");
    }

    public function show(Request $request){
        $id = request()->get("id");

        $pdo = DB::getPdo();
        $asignaturaDAO = new AsignaturaDAO($pdo);


    }
}
